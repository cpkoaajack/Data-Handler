package core.comp3111;

import java.io.Serializable;
import java.util.Arrays;

/**
 * DataColumn - A column of data. This class will be used by DataTable. It
 * stores the data values (data) and the its type (typeName). String constants
 * of type name are defined in DataType.
 * 
 * @author cspeter
 *
 */
public class DataColumn implements Serializable {

	/**
	 * Constructor. Create an empty data column
	 */
	public DataColumn() {
		data = null;
		typeName = "";
	}

	/**
	 * Constructor. Create a data column by giving the typename and array of Object
	 * 
	 * @param typeName
	 *            - defined in DataType. Should be matched with the type of the
	 *            array element
	 * @param values
	 *            - any Java Object array
	 */
	public DataColumn(String typeName, Object[] values) {
		set(typeName, values);
	}

	/**
	 * Associate a Java Object array (with the correct typeName) to DataColumn
	 * 
	 * @param typeName
	 *            - defined in DataType. Should be matched with the type of the
	 *            array element
	 * @param values
	 *            - any Java Object array
	 */
	public void set(String typeName, Object[] values) {
		this.typeName = typeName;
		data = values;
	}

	/**
	 * Get the data array
	 * 
	 * @return The Object[]. Developers need to downcast it based on the type name
	 */
	public Object[] getData() {
		return data;
	}

	/**
	 * Get the type name
	 * 
	 * @return the type name, defined in DataType
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Get the number of elements in the data array
	 * 
	 * @return 0 if data is null. Otherwise, length of the data array
	 */
	public int getSize() {
		if (data == null)
			return 0;
		return data.length;
	}
	
	public void fillin(float num) {

		for(int i = 0; i < data.length; i++) {
			if(data[i] == null)
				data[i] = num;
		}
	}
	
	public float getMean() {
		int mean = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null)
			mean += (float) data[i];
		}
		mean /= data.length;
		return mean;
	}
	
	public float getMedian() {
		Object[] temp = data.clone();	
		Arrays.sort(temp);
		int counter = 0;
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != null)
				counter++;
		}
		if(counter % 2 == 0)
			return ((float)temp[counter/2] + (float)temp[counter/2+1]) / 2;
		else
			return (float)temp[counter/2];
	}

	// attributes
	private Object[] data;
	private String typeName;

}
