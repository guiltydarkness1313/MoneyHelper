package com.shibuyaxpress.moneyhelper.models;

/**
 * Created by paulf on 16-Sep-17.
 */

public class Saldo {
    private String tipoSaldo;
    private double montoSaldo=0;
    private double ingreso=0;
    private double egreso=0;
    private double ahorroActual;
    private double creditoActual;
    private double efectivoActual;
    private String tipoCuenta;
    private Double saldoTotal=0.0;

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    private static Saldo mySaldo;

    public double getAhorroActual() {
        return ahorroActual;
    }

    public void setAhorroActual(double ahorroActual) {
        this.ahorroActual = ahorroActual;
    }

    public double getCreditoActual() {
        return creditoActual;
    }

    public void setCreditoActual(double creditoActual) {
        this.creditoActual = creditoActual;
    }

    public double getEfectivoActual() {
        return efectivoActual;
    }

    public void setEfectivoActual(double efectivoActual) {
        this.efectivoActual = efectivoActual;
    }

    public static Saldo getInstance(){
        if(mySaldo==null){
            mySaldo=new Saldo();
        }
        return mySaldo;
    }

    private Saldo() {
    }

    public String getTipoSaldo() {
        return tipoSaldo;
    }

    public void setTipoSaldo(String tipoSaldo) {
        this.tipoSaldo = tipoSaldo;
    }

    public double getMontoSaldo() {
        return montoSaldo;
    }

    public void setMontoSaldo(double montoSaldo) {
        this.montoSaldo = montoSaldo;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso,String tipoCuenta) {

        switch (tipoCuenta){
            case "Tarjeta de Crédito":
                creditoActual+=ingreso;
                saldoTotal+=ingreso;
                Saldo.getInstance().setCreditoActual(creditoActual);
                Saldo.getInstance().setSaldoTotal(saldoTotal);
                break;

            case "Ahorro":
                ahorroActual+=ingreso;
                saldoTotal+=ingreso;
                Saldo.getInstance().setAhorroActual(ahorroActual);
                Saldo.getInstance().setSaldoTotal(saldoTotal);
                break;
            case "Efectivo":
                efectivoActual+=ingreso;
                saldoTotal+=ingreso;
                Saldo.getInstance().setEfectivoActual(efectivoActual);
                Saldo.getInstance().setSaldoTotal(saldoTotal);
                break;

        }
        //this.ingreso = ingreso;
    }

    public int ProporcionMonto(){
        double prop = 0;
        try {
            if(egreso==0){
                prop=100;
            }else {
                prop = 100+(-1*((egreso / Saldo.getInstance().getSaldoTotal()) * 100));
                //prop*=100;
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return (int) prop;
    }
    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double megreso,String tipoCuenta) {
        switch (tipoCuenta){
            case "Tarjeta de Crédito":
                creditoActual-=megreso;
                egreso+=megreso;
                break;

            case "Ahorro":
                ahorroActual-=megreso;
                egreso+=megreso;
                break;
            case "Efectivo":
                efectivoActual-=megreso;
                egreso+=megreso;
                break;

        }
        //this.egreso = egreso;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Saldo{" +
                "tipoSaldo='" + tipoSaldo + '\'' +
                ", montoSaldo=" + montoSaldo +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                '}';
    }
}
