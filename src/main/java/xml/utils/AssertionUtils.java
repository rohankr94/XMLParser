package xml.utils;



public final class AssertionUtils {

    public static void assertStringNotNullOrEmpty(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            throw new AssertionException("String shall not be null or empty");
        }
    }

    public static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new AssertionException("Object shall not be null");
        }
    }

    public static void assertTrue(boolean result) {
        if (!result) {
            throw new AssertionException(
                    "Condition is not met. Expected result to be true but found false.");
        }
    }

    public static void assertTrue(boolean result, String message) {
        if (!result) {
            throw new AssertionException(message);
        }
    }

    public static void assertFalse(boolean result) {
        if (result) {
            throw new AssertionException(
                    "Condition is not met. Expected result to be false but found true.");
        }
    }

}
