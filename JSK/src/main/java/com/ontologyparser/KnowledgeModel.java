package main.java.com.ontologyparser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.jena.ontology.HasValueRestriction;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.ontology.SomeValuesFromRestriction;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDFS;

public class KnowledgeModel {
	
	private OntModel ontology;
	
	public KnowledgeModel() {
		// First, set the path, as this is needed to create the ontology
		String path = this.getClass().getResource("/main/resources/data/dataset.owl").getPath();
		
		// Create a new model that can use inference
		ontology = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_TRANS_INF);
		
		// With the ontology path set, it's time to read it
		ontology.read(path);
	}
	
	// Get the data gathered in OWL for a class
	private ArrayList<String> getRawData(OntClass classWanted) {
		
		// Prepare the raw data
		ArrayList<String> res = new ArrayList<String>();
		
		// Get inferred information from the ontology, based on the superclasses and pseudo-superclasses of classWanted
		for (Iterator<OntClass> i = classWanted.listSuperClasses(); i.hasNext(); ) {
			OntClass superClass = i.next();
			
			// Handle restriction-based pseudo-classes
			if (superClass.isRestriction()) {
			    Restriction r = superClass.asRestriction();
			    
			    // Handle has-value restrictions
			    if(r.isHasValueRestriction()) {
				    HasValueRestriction hv = r.asHasValueRestriction();
				    
				    // The property with the has-value restriction
				    String property = hv.getOnProperty().asResource().getProperty(RDFS.label).getString();
				    
				    // The instance that acts as range
				    String range = hv.getHasValue().asResource().getProperty(RDFS.label).getString();
				    
				    // Add human-readable string to the list of facts
				    res.add(property + " " + range + " values");
			    }
			    
			    // Handle some-value restrictions
			    else if(r.isSomeValuesFromRestriction()) {
			    	SomeValuesFromRestriction sv = r.asSomeValuesFromRestriction();
			    	
			    	// The property with the has-value restriction
			    	String property = sv.getOnProperty().asResource().getProperty(RDFS.label).getString();
			    	
			    	// The class that acts as range
			    	String range = sv.getSomeValuesFrom().listProperties(RDFS.label).next().getString();
			    	
			    	// Add human-readable string to the list of facts
			    	res.add(property + " some " + range);
			    }
			}
			// Handle actual defined classes rather than pseudo-superclasses
			else if(superClass.isClass()){
				// Get superclass label
				String sc = superClass.getProperty(RDFS.label).getString();
				
				// Add human-readable string to the list of facts
				res.add("is a " + sc);
			}
		}
		
		return res;
	}
	
	// Format the data for the body of the JSP modal
	private String getFormattedData(OntClass classWanted) {
		// Initialise the return string
		String ret = "";
		
		// Get all the raw information about this class in the ontology
		ArrayList<String> info = getRawData(classWanted);
		
		// Organise the data alphabetically
		// This will group facts that use the same property closer together and make them look more organised
		Collections.sort(info);
		
		// Create the information displayed inside the modal
		
		// 1. Definition
		ret += ("<br/><p>Definition: " + classWanted.getProperty(RDFS.isDefinedBy).getString() + "</p>");
		
		// 2. Example
		ret += addCodeSnippet(classWanted);
		
		// 3. Features
		ret += ("<br/><p>Features identified by the reasoner: </p>");
		
		// From the raw data, extract the natural language sentences and add them to an unordered list
		ret += "<ul>";
		for (int i = 1; i < info.size(); i++){
			ret += ("<li>" + info.get(i) + "</li>");
		}
		ret += "</ul>";
		
		// Finally, return the HTML element to represent classWanted
		return ret;
	}
	
	// Return an HTML image component if there is a flag requesting it in the ontology
	// Otherwise return nothing
	private String addCodeSnippet(OntClass className) {
		
		if(className.hasProperty(RDFS.seeAlso)) {
			if(className.getProperty(RDFS.seeAlso).getString().equals("has snippet")) {
				
				return "<img class=\"img-fluid\" src = \"images/" + className.getLocalName() + ".PNG\"\" alt=\"" + className.getLocalName() + " example snippet\">";
			}
		}
		
		return "";
	}
	
	// Set up the whole display of a class
	// That is, the button and the corresponding modal with all the information
	// Params: class to be represented and the desired button colour
	private String getDisplayableKnowledge(OntClass classWanted, String colour) {
		
		String label = classWanted.getProperty(RDFS.label).getString();
		
		String details =   "<button type=\"button\" class=\"btn btn-" + colour + " btn-lg\" style=\"margin: 10px\" data-toggle=\"modal\" data-target=\"#"+ classWanted.getLocalName() + "\">\r\n"
				    + 			label
					+ "		</button>\r\n"
					+ "		\r\n"
					+ "		<!-- Modal -->\r\n"
					+ "		<div class=\"modal fade\" id=\"" + classWanted.getLocalName() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\r\n"
					+ "  		<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n"
					+ "    		<div class=\"modal-content\">\r\n"
					+ "      		<div class=\"modal-header\">\r\n"
					+ "        		<h5 class=\"modal-title\" id=\"exampleModalLongTitle\">" + label + "</h5>\r\n"
					+ "        		<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
					+ "          		<span aria-hidden=\"true\">&times;</span>\r\n"
					+ "        		</button>\r\n"
					+ "      		</div>\r\n"
					+ "      		<div class=\"modal-body\">\r\n"
					+          			getFormattedData(classWanted)
					+ "      		</div>\r\n"
					+ "    		</div>\r\n"
					+ "  		</div>\r\n"
					+ "		</div>";
		
		return details;
	}
	
	// Print information on all the classes in a category
	// Parameters: the category where the class should be displayed and the colour of the button
	// Return the whole collection of buttons that will go under that section
	public String getCategory(String category, String buttonColour) {
		// Initiate the entire result
		String res = "";
		
		// Prepare the variables
		ExtendedIterator<OntClass> classes = ontology.listClasses();
		
		// Add all the buttons 
		while(classes.hasNext()) {
			OntClass currentClass = classes.next();
			
			// A class with no local name is a pseudo-superclass, so we avoid those
			if (currentClass.getLocalName() != null){	
				// Check whether the class belongs to the category being created
				if(currentClass.getProperty(RDFS.comment) != null) {
					if(currentClass.getProperty(RDFS.comment).getString().equals(category)) {
						res += getDisplayableKnowledge(currentClass, buttonColour);
					}					
				}
			}
		}
		
		return res;
	}
}
