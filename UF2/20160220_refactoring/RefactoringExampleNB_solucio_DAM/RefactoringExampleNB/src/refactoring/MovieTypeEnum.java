package refactoring;

/**
 *
 * @author BERNAT
 */
public enum MovieTypeEnum {

    CHILDRENS(MovieType_Children.class),
    NEW_RELEASE(MovieType_NewRelease.class),
    REGULAR(MovieType_Regular.class);

    private Class mC;

    MovieTypeEnum(Class c) {
        mC = c;
    }

    public Class getC() {
        return mC;
    }

}
