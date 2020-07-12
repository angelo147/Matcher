package gr.angelo.functional.condition;

public class PredicateEvaluationException extends RuntimeException {
    /**
     * Constructs a <code>PredicateEvaluationException</code> with <tt>null</tt>
     * as its error message string.
     */
    public PredicateEvaluationException() {
        super();
    }

    /**
     * Constructs a <code>PredicateEvaluationException</code>, saving a reference
     * to the error message string <tt>s</tt> for later retrieval by the
     * <tt>getMessage</tt> method.
     *
     * @param   s   the detail message.
     */
    public PredicateEvaluationException(String s) {
        super(s);
    }
}
