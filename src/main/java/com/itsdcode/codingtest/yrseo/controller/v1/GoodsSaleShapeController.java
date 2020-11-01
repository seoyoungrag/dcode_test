package com.itsdcode.codingtest.yrseo.controller.v1;

import com.itsdcode.codingtest.yrseo.common.modelmap.ObjectMapperUtils;
import com.itsdcode.codingtest.yrseo.common.response.ListResult;
import com.itsdcode.codingtest.yrseo.common.response.ResponseService;
import com.itsdcode.codingtest.yrseo.dto.GoodsSaleShapeDTO;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleShapeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "3. GoodsSaleShape" })
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/goodsSaleShape")
public class GoodsSaleShapeController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    private final ResponseService responseService;
    private final GoodsSaleShapeRepository goodsSaleShapeRepository;

    @ApiOperation(value = "모든 상품 정보의 상세내용 조회", notes = "모든 상품의 상세내용을 조회한다.")
    @GetMapping
    public ListResult<GoodsSaleShapeDTO> findAll() {
        return responseService.getListResult(ObjectMapperUtils.mapAll(goodsSaleShapeRepository.findAll(), GoodsSaleShapeDTO.class));
    }
}
