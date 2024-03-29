package gr.angelo.functional.condition;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Matcher<T> {
    private final T value;

    private Matcher(T value) {
        this.value = value;
    }

    /**
     * Use a static import for this method.
     *
     * @param value kk
     * @param <T>   kk
     * @return Returns a Matcher instance encapsulating the given value.
     */
    public static <T> Matcher<T> Match(T value) {
        Objects.requireNonNull(value);
        return new Matcher<>(value);
    }

    public Case<T> of(Predicate<T> tPredicate) {
        Objects.requireNonNull(tPredicate);
        return new Case<>(tPredicate, value);
    }

    public static final class Moment {
        private final boolean aBoolean;

        private Moment(boolean aBoolean) {
            this.aBoolean = aBoolean;
        }

        public static Moment ofTruth() {
            return new Moment(true);
        }

        public static Moment ofUnTruth() {
            return new Moment(false);
        }

        public void orElseRun(Runnable runnable) {
            if (aBoolean)
                runnable.run();
        }
    }

    public static final class Case<T> {
        private final Predicate<T> tPredicate;
        private final T value;

        public Case(Predicate<T> tPredicate, T value) {
            this.tPredicate = tPredicate;
            this.value = value;
        }

        public <U> U match(Supplier<U> supplier) {
            if (tPredicate.test(value))
                return supplier.get();
            else throw new PredicateEvaluationException("Predicate evaluation is false");
        }

        public <U> Optional<U> ifMatch(Supplier<U> supplier) {
            if (tPredicate.test(value))
                return Optional.of(supplier.get());
            else return Optional.empty();
        }

        public Moment ifMatch(Runnable runnable) {
            if (tPredicate.test(value)) {
                runnable.run();
                return Moment.ofUnTruth();
            } else return Moment.ofTruth();
        }
    }
}
