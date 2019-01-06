Practices Used:
* Dependency injection of data structures
    * Makes it easier for testing
*
Lessons Learned (Mistakes Were Made):
* Java
    * Enums can be associated with their ordinal value (position they are declared). No need
    for long switch-case statements.
    * Enums implement the Comparable interface and are ordered based on the position they are declared.
    * Use comparable in most cases. Comparator is used for unnatural ordering.
    * It is possible to sort using Collections.sort or List.sort
    * The sort method can take in Comparator.naturalOrdering() for a comparator
    * Integer has a built-in static compare method (nice tidbit).
* Maven
    * Use RELEASE or LATEST for dependency versions