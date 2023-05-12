package iuh.edu.vn.dreamtrip.dto;

import iuh.edu.vn.dreamtrip.entity.NguoiDung;
import iuh.edu.vn.dreamtrip.entity.TaiKhoan;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class TaiKhoanAdminUserDTO {
	private TaiKhoan tk;
	private NguoiDung nguoiDung;
	
}
