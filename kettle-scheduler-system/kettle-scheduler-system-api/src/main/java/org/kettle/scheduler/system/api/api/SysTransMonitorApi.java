package org.kettle.scheduler.system.api.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kettle.scheduler.common.povo.PageOut;
import org.kettle.scheduler.common.povo.QueryHelper;
import org.kettle.scheduler.common.povo.Result;
import org.kettle.scheduler.system.api.basic.IdVO;
import org.kettle.scheduler.system.api.request.MonitorQueryReq;
import org.kettle.scheduler.system.api.response.TransMonitorRes;
import org.kettle.scheduler.system.api.response.TransRecordRes;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 转换监控管理API
 *
 * @author lyf
 */
@Api(tags = "转换监控管理API")
@RequestMapping("/sys/trans/monitor")
public interface SysTransMonitorApi {

    /**
     * 根据条件查询转换监控列表
     *
     * @param req {@link QueryHelper}
     * @return {@link Result}
     */
    @ApiOperation(value = "根据条件查询转换监控列表")
    @PostMapping("/findTransMonitorListByPage")
    Result<PageOut<TransMonitorRes>> findTransMonitorListByPage(@RequestBody QueryHelper<MonitorQueryReq> req);

    /**
     * 查询转换id查询转换执行记录
     *
     * @param req 根据转换id查询
     * @return {@link Result}
     */
    @ApiOperation(value = "查询转换监控明细")
    @PostMapping("/findTransRecordList")
    Result<PageOut<TransRecordRes>> findTransRecordList(@RequestBody QueryHelper<IdVO> req);

    /**
     * 查看转换执行记录明细
     *
     * @param transRecordId 根据转换记录id查询
     * @return {@link Result}
     */
    @ApiOperation(value = "查看转换执行记录明细")
    @GetMapping("/viewTransRecordDetail")
    Result<String> viewTransRecordDetail(@RequestParam("transRecordId") Integer transRecordId);

    /**
     * 下载转换执行记录明细
     *
     * @param response 响应结果
     * @param transRecordId 根据转换记录id查询
     */
    @ApiOperation(value = "下载转换执行记录明细")
    @GetMapping("/downloadTransRecord")
    void downloadTransRecord(HttpServletResponse response, @RequestParam("transRecordId") Integer transRecordId);
}
