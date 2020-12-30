package com.saltlux.intern.vo;

public class resultVO {
	
	private int simple;
	private int nonSpecial;
	private int tms;
	private int nonSpecialTms;
	
	public int getSimple() {
		return simple;
	}
	public void setSimple(int simple) {
		this.simple = simple;
	}
	public int getNonSpecial() {
		return nonSpecial;
	}
	public void setNonSpecial(int nonSpecial) {
		this.nonSpecial = nonSpecial;
	}
	public int getTms() {
		return tms;
	}
	public void setTms(int tms) {
		this.tms = tms;
	}
	public int getNonSpecialTms() {
		return nonSpecialTms;
	}
	public void setNonSpecialTms(int nonSpecialTms) {
		this.nonSpecialTms = nonSpecialTms;
	}
	
	@Override
	public String toString() {
		return "resultVO [simple=" + simple + ", nonSpecial=" + nonSpecial + ", tms=" + tms + ", nonSpecialTms="
				+ nonSpecialTms + "]";
	}
	
	
	
}
