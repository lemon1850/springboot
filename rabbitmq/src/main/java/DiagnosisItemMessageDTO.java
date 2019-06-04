/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-25
 * @Version 1.0
 */

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiagnosisItemMessageDTO {
    /**
     * 诊断项类型，参照枚举
     */
    private int type;
    /**
     * 诊断问题级别，1：无问题，2：问题一般，3：问题严重
     *
     * @desc 问题严重的商户需要打标签，如：曝光UV的问题严重，则商户标签为"曝光UV低"
     */
    private int level = 1;
    /**
     * 商户自身数据，个别指标为统计日期当前的数据，个别指标为近七日数据，起送价为近7天最小值，配送费为近七天平均值
     * 1. 按天维度计算指标
     * 营业达标率、商品有图率、商户补贴力度、出餐时长、T+8超时率、订单催单率、商户拒单率、差评率、投诉率、热销商品沽清率、毛gmv、净gmv
     * <p>
     * 2. 按近7日加和计算指标
     * 曝光UV，曝光率、进店转化率、下单转化率、老客复购率、下单新客数、商品动销率、 高峰期营业达标率
     * <p>
     * 3. 特殊指标
     * 起送价：近7日最小值
     * 配送费：近七日平均值
     */
    private double data = 0;
}