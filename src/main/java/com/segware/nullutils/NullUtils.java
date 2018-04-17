package com.segware.nullutils;

class NullUtils {

    private NullUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNotNull(final Object object, final String methods) {
        try {
            if (object == null) {
                return false;
            }
            if (methods == null || methods.isEmpty()) {
                return false;
            }
            final String[] split = methods.split("\\.");
            Object toVerify = object;
            for (final String method : split) {
                final Object invoke = toVerify.getClass().getMethod(method).invoke(toVerify);
                if (invoke == null) {
                    return false;
                }
                toVerify = invoke;
            }

        } catch (final Exception e) {
            return false;
        }
        return true;
    }
}