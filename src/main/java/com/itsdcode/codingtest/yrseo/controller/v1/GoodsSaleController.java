package com.itsdcode.codingtest.yrseo.controller.v1;

import com.itsdcode.codingtest.yrseo.common.modelmap.ObjectMapperUtils;
import com.itsdcode.codingtest.yrseo.common.response.ListResult;
import com.itsdcode.codingtest.yrseo.common.response.ResponseService;
import com.itsdcode.codingtest.yrseo.dto.GoodsSaleDTO;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleRepository;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleShapeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "2. GoodsSale" })
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/goodsSale")
public class GoodsSaleController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    private final ResponseService responseService;
    private final GoodsSaleRepository goodsSaleRepository;
    private final GoodsSaleShapeRepository goodsSaleShapeRepository;

    @ApiOperation(value = "모든 상품 판매 정보 조회", notes = "모든 상품 판매 정보를 조회한다.")
    @GetMapping("/test")
    public ListResult<GoodsSaleDTO> findAll() {
        return responseService.getListResult(ObjectMapperUtils.mapAll(goodsSaleRepository.findAll(), GoodsSaleDTO.class));
    }

}
