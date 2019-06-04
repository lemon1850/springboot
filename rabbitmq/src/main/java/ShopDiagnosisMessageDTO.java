import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-25
 * @Version 1.0
 */

@Data
@NoArgsConstructor
public class ShopDiagnosisMessageDTO {
    /**
     * 计算日期, t+1
     */

    private LocalDate dtDate;
    /**
     * 门店ID
     */
    private Long shopId;
    /**
     * 诊断项
     */
    private List<DiagnosisItemMessageDTO> items;
}