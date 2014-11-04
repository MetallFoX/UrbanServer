package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Advertising;
import com.urban.data.Event;
import com.urban.data.Image;
import com.urban.data.Organization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

@DatabaseTable(tableName="Image")
public class ImagePojo implements Image {
	
	public ImagePojo() {
	
	}
	
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField(dataType = DataType.BYTE_ARRAY)
    private byte[] binaryContent;

	/*@Override
	public byte[] getAsBinary() {
		return binaryContent;
	}

	@Override
	public InputStream getAsStream() {
		return new ByteArrayInputStream(binaryContent);
	}
	*/
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public byte[] getBinaryContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Advertising> getAdvertising() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Organization> getOrganization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Event> getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getAsStream() {
		return new ByteArrayInputStream(binaryContent);
	}
}
