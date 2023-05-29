import java.io.*;
import java.util.*;



public class DelivA {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	//Constructor - DO NOT MODIFY
	public DelivA(File in, Graph gr) {
		inputFile = in;
		graph = gr;

		// Set up for writing to a file
		try {
			// Use input file name to create output file in the same location
			String inputFileName = inputFile.toString();
			String outputFileName = inputFileName.substring(0, inputFileName.length() - 4).concat("_out.txt");
			outputFile = new File(outputFileName);

			// A Printwriter is an object that can write to a file
			output = new PrintWriter(outputFile);
		} catch (Exception x) {
			System.err.format("Exception: %s%n", x);
			System.exit(0);
		}
		
		// Calls the method that will do the work of deliverable A
		runDelivA();

		output.flush();
	}

	//*********************************************************************************
	//               This is where your work starts
	private void runDelivA() {
		// sort Nodes in a descending order by indegree

		// New apporoach
		ArrayList<Node> nodeList = graph.getNodeList();

		Collections.sort(nodeList, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {

				if (n1.getIncomingEdges().size() > n2.getIncomingEdges().size()) {
					return -1; // n1 comes before n2
				} else if (n1.getIncomingEdges().size() < n2.getIncomingEdges().size()) {
					return 1; // n1 comes after n2
				} else if (n1.getIncomingEdges().size() == n2.getIncomingEdges().size()) {

					// Sort be outdegree in a decending order
					if (n1.getOutgoingEdges().size() > n2.getOutgoingEdges().size()) {
						return -1; // n1 comes before n2
					} else if (n1.getOutgoingEdges().size() < n2.getOutgoingEdges().size()) {
						return 1; // n1 comes after n2
					} else if (n1.getOutgoingEdges().size() == n2.getOutgoingEdges().size()) {
						return n1.getAbbrev().compareTo(n2.getAbbrev());
					} else {
						return 0;
					}
				} else {
					return 0;
				}
			}
		});
	System.out.println();
		System.out.println("Indegree: ");
		for (Node node : nodeList) {
			System.out.println("Node " + node.getAbbrev() + " has indegree " + node.getIncomingEdges().size());
		}


		// sort Nodes in a descending order by outdegree

		Collections.sort(nodeList, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {

				if (n1.getOutgoingEdges().size() > n2.getOutgoingEdges().size()) {
					return -1; // n1 comes before n2
				} else if (n1.getOutgoingEdges().size() < n2.getOutgoingEdges().size()) {
					return 1; // n1 comes after n2
				} else if (n1.getOutgoingEdges().size() == n2.getOutgoingEdges().size()) {

					// Sort be indegree in a decending order
					if (n1.getIncomingEdges().size() > n2.getIncomingEdges().size()) {
						return -1; // n1 comes before n2
					} else if (n1.getIncomingEdges().size() < n2.getIncomingEdges().size()) {
						return 1; // n1 comes after n2
					} else if (n1.getIncomingEdges().size() == n2.getIncomingEdges().size()) {
						return n1.getAbbrev().compareTo(n2.getAbbrev());
					} else {
						return 0; // equal
					}
				} else {
					return 0; // equal
				}
			}
		});


		System.out.println();
		System.out.println("Outdegree: ");
		for (Node node : nodeList) {
			System.out.println("Node " + node.getAbbrev() + " has outdegree " + node.getOutgoingEdges().size());
		}
// Previous Approach

		// System.out.println("Sorted by indegree: ");
		// for (Node node : nodeList) {
		// 	System.out.println("Node " + node.getAbbrev() + " has indegree " + node.getIncomingEdges().size());
		// }

		// try {
		// 	Scanner scanner = new Scanner(inputFile);

		// 	String[] Nodes = scanner.nextLine().replace("~", "").replace("val", "").trim().split(" +");
		// 	System.out.println();

		// 		int index = 0;
		// 		int[] inDegreeArray = new int[Nodes.length];
		// 		int[] outDegreeArray = new int[Nodes.length];

		// 		while (scanner.hasNextLine()) {

		// 			String line = scanner.nextLine();
		// 			String[] splitString = line.split(" +");

		// 			for (int i = 2; i < splitString.length; i++) {

		// 				if (!splitString[i].equals("~")) {
		// 					inDegreeArray[i - 2]++;
		// 				}

		// 				if (!splitString[i].equals("~")) {
		// 					outDegreeArray[index] = outDegreeArray[index] + 1;
		// 				}
		// 			}

		// 			index++;
		// 		}
		// 		// use foreach loop for graph.getNodeList() and get the node and set the indegree and outdegree

		// 		System.out.println("Indegree:");

		// 		for (int i = 0; i < Nodes.length; i++) {
		// 			System.out.println("Node " + Nodes[i] + " has indegree " + inDegreeArray[i]);
		// 		}
		// 		System.out.println("Outdegree:");
		// 		for (int i = 0; i < Nodes.length; i++) {
		// 			System.out.println("Node " + Nodes[i] + " has outdegree " + outDegreeArray[i]);
		// 		}
		//         scanner.close();
		// 	} catch (FileNotFoundException e) {
		// 		System.err.format("FileNotFoundException: %s%n", e);
		// 	}

	}

}
