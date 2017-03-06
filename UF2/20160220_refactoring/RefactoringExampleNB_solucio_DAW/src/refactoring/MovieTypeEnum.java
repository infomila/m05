/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoring;

/**
 *
 * @author BERNAT
 */
public enum MovieTypeEnum {
    REGULAR(MovieTypeRegular.class) ,
    NEW_RELEASE(MovieTypeNewRelease.class) ,
    CHILDRENS(MovieTypeChildren.class) ;    
    private Class mMT;    
    MovieTypeEnum(Class m) {
        mMT = m;
    }    
    public Class getC() {
        return mMT;
    }
  
}
