package at.mhofer.jam.data.attributes;

/**
 * TODO
 * 
 * @author Mathias
 *
 */
public class ElementValue
{
//	element_value {
//		u1 tag;
//		union {
//		u2 const_value_index;
//		{ u2 type_name_index;
//		u2 const_name_index;
//		} enum_const_value;
//		u2 class_info_index;
//		annotation annotation_value;
//		{ u2 num_values;
//		element_value values[num_values];
//		} array_value;
//		} value;
//		}
//	
	private short tag;
	
	public short getTag()
	{
		return tag;
	}
}
