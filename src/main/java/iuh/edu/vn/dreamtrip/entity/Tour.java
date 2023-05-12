package iuh.edu.vn.dreamtrip.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9220956547091492679L;
	@DocumentId
	private String document_id;
	private String tenTour;
	private String thongTin;
	private String viTri;
	private int soNgay;
	private List<String> phuongTien;
	private List<String> hinhAnh;
	private List<String> theLoai;
	private double danhGia;
	private boolean phoBien;
	private boolean xuHuong;
	private double longitude;
	private double latitude;
}
