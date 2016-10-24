/**
 * MapType - Enum to encapsulate the values a point on a map can be
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: October 24, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public enum MapType {

    Wall            ('W'),
    Blank           (' '),
    End             ('E'),
    Visited         ('V');

    private final char character;

    /**
     * constructs the enum
     * @param character
     */
    MapType(char character) {
        this.character = character;
    }

    /**
     * return the character value of the type
     * @return
     */
    public char toChar() {
        return character;
    }

    /**
     * create a MapType from a char. Throws exception if char is invalid
     * @param character
     */
    public static MapType fromChar(char character) {
        for (MapType mapType : MapType.values()) {
            if (mapType.toChar() == character) {
                return mapType;
            }
        }

        throw new IllegalArgumentException(String.format("Character `%s` is not valid", character));
    }
}
