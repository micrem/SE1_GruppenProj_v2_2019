package cardReader;

/**
 * k o - no scanner access
 * I: 1234
 * S: 5
 * T: 6
 *
 * 1 MoveBeltForward
 * 2 MoveBeltBackwards
 * 3 Scan
 * 4 Alarm
 * 5 Record
 * 6 Maintenance
 */
public enum ProfileType {
    K,
    O,
    I,
    S,
    T
}
