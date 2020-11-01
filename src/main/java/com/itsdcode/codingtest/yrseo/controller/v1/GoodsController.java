package com.itsdcode.codingtest.yrseo.controller.v1;

import com.itsdcode.codingtest.yrseo.common.modelmap.ObjectMapperUtils;
import com.itsdcode.codingtest.yrseo.common.response.ListResult;
import com.itsdcode.codingtest.yrseo.common.response.ResponseService;
import com.itsdcode.codingtest.yrseo.dto.GoodsDTO;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "1. Goods" })
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/goods")
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    private final ResponseService responseService;
    private final GoodsRepository goodsRepository;

    @ApiOperation(value = "모든 상품 조회", notes = "모든 상품을 조회한다.")
    @GetMapping("/test")
    public ListResult<GoodsDTO> findAll() {
        return responseService.getListResult(ObjectMapperUtils.mapAll(goodsRepository.findAll(), GoodsDTO.class));
    }
}
