/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarifesteatre;


public enum TipusSeient {
    PLATEA(60),
    LATERAL(50),
    PRIMER_PIS(40),
    SEGON_PIS(30);

    private double mPreu;
    TipusSeient (double preu) {
        mPreu = preu;
    }
    public double getPreu(){ return mPreu;}

}