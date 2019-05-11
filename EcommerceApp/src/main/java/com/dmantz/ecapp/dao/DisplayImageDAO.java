package com.dmantz.ecapp.dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

@Repository
public class DisplayImageDAO {

    public ResponseEntity<byte[]> displayImage(String imgId) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("loaded");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userapp", "root", "12345");
	System.out.println("connection created.");
	String sql="select * from product_sku_image where product_sku_image_id="+imgId;
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
    
    while(rs.next()) {
    	String imgURL=rs.getString(3);
        Blob imgBlob=rs.getBlob(4);
        FileOutputStream fileOPStream=new FileOutputStream("src/main/resources/images/"+imgURL);
        fileOPStream.write(imgBlob.getBytes(1, (int)imgBlob.length()));
       System.out.println("image saved");
        fileOPStream.close();
        
    InputStream is=new BufferedInputStream(new FileInputStream("src/main/resources/images/"+imgURL));
            byte[] bytes = StreamUtils.copyToByteArray(is);

		
		  return ResponseEntity .ok() .contentType(MediaType.IMAGE_JPEG) .body(bytes);
		   
    }  
 	   
 	   
 	    
rs.close();
return null;
	
}

	
}
