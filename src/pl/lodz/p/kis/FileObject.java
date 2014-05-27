package pl.lodz.p.kis;

import java.util.Arrays;

/**
 * Klasa reprezentuje pojedynczy obiekt zaciągniety z pliku.
 * Wykorzystywany podczas klasyfikacji.
 */
public class FileObject implements Cloneable, Comparable<FileObject>{
	public static final int CLASS_A = 0;
	public static final int CLASS_B = 1;
	public static final int UNCLASSIFIED = -1;
	
	private double[] features;
	private int classType;
	private int id; //  numer obiektu
	
	public FileObject(int numberOfFeatures) {
		features = new double[numberOfFeatures];
	}
	
	public FileObject(double[] features, int type, int id) {
		this.features = Arrays.copyOf(features, features.length);
		this.classType = type;
		this.id = id;
	}

	public double[] getFeatures() {
		return features;
	}

	public void setFeatures(double[] features) {
		this.features = features;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(classType) + " | " + Arrays.toString(features);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		FileObject result = (FileObject) super.clone();
		result.features = Arrays.copyOf(this.features, this.features.length);
		result.classType = this.classType;
		result.id = this.id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		FileObject val = (FileObject) obj;
		return this.id == val.getId();
	}
	
	@Override
	public int compareTo(FileObject o) {
		return this.classType - o.classType;
	}
}
