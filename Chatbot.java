import java.util.HashMap;
import java.util.Map;

public class Chatbot {

    private Map<String, String> responses;

    public Chatbot() {
        responses = new HashMap<>();
        trainBot();
    }

    // Train chatbot with frequently asked questions
    private void trainBot() {

        responses.put("hello",
                "Hello! How can I help you?");

        responses.put("hi",
                "Hi! Nice to meet you.");

        responses.put("hey",
                "Hey! How can I help you?");

        responses.put("name",
                "My name is JavaBot.");

        responses.put("who are you",
                "I am a Java-based NLP chatbot.");

        responses.put("how are you",
                "I am doing great! Thanks for asking.");

        responses.put("java",
                "Java is a popular object-oriented programming language.");

        responses.put("nlp",
                "NLP stands for Natural Language Processing.");

        responses.put("machine learning",
                "Machine Learning allows computers to learn from data.");

        responses.put("help",
                "You can ask me about Java, NLP, Machine Learning and programming.");

        responses.put("thank",
                "You're welcome!");

        responses.put("bye",
                "Goodbye! Have a nice day.");
    }

    // NLP preprocessing
    private String preprocess(String input) {

        // Convert text to lowercase
        input = input.toLowerCase();

        // Remove punctuation
        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        // Remove extra spaces
        input = input.trim();

        return input;
    }

    // Generate chatbot response
    public String getResponse(String input) {

        String text = preprocess(input);

        if (text.isEmpty()) {
            return "Please enter a message.";
        }

        // Exact matching
        if (responses.containsKey(text)) {
            return responses.get(text);
        }

        // Keyword matching

        if (text.contains("hello") ||
            text.contains("hi") ||
            text.contains("hey")) {

            return responses.get("hello");
        }

        if (text.contains("name") ||
            text.contains("who are you")) {

            return responses.get("name");
        }

        if (text.contains("java")) {
            return responses.get("java");
        }

        if (text.contains("nlp") ||
            text.contains("natural language")) {

            return responses.get("nlp");
        }

        if (text.contains("machine learning") ||
            text.contains("ml")) {

            return responses.get("machine learning");
        }

        if (text.contains("thank")) {
            return responses.get("thank");
        }

        if (text.contains("bye") ||
            text.contains("goodbye")) {

            return responses.get("bye");
        }

        // Default response
        return "Sorry, I don't understand that question. "
             + "Please ask another question.";
    }
}