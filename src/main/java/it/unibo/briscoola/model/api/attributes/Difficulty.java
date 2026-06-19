package it.unibo.briscoola.model.api.attributes;

/**
 * The possible difficulties that the CPU can accept.
 */
public enum Difficulty {
        EASY(1),
        MEDIUM(1.5),
        HARD(2);

        public final double value;
        Difficulty(double value){
            this.value = value;
        }
}
