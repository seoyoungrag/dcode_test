package com.itsdcode.codingtest.yrseo.controller.v1;

import com.itsdcode.codingtest.yrseo.common.advice.exception.CResourceNotExistException;
import com.itsdcode.codingtest.yrseo.common.modelmap.ObjectMapperUtils;
import com.itsdcode.codingtest.yrseo.common.response.ListResult;
import com.itsdcode.codingtest.yrseo.common.response.ResponseService;
import com.itsdcode.codingtest.yrseo.dto.GoodsConditionForDCODE;
import com.itsdcode.codingtest.yrseo.dto.GoodsDTOForDCODE;
import com.itsdcode.codingtest.yrseo.dto.GoodsSaleDTO;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleRepository;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleShapeRepository;
import com.itsdcode.codingtest.yrseo.repository.goods.QGoodsSaleShapeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "2. GoodsSale" })
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/goodsSale")
public class GoodsSaleController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    private final ResponseService responseService;
    private final GoodsSaleRepository goodsSaleRepository;
    private final GoodsSaleShapeRepository goodsSaleShapeRepository;
    private final QGoodsSaleShapeRepository qGoodsSaleShapeRepository;

    @ApiOperation(value = "모든 상품 판매 정보 조회", notes = "모든 상품 판매 정보를 조회한다.")
    @GetMapping("/test")
    public ListResult<GoodsSaleDTO> findAll() {
        return responseService.getListResult(ObjectMapperUtils.mapAll(goodsSaleRepository.findAll(), GoodsSaleDTO.class));
    }

    @ApiOperation(value = "모든 대표상품 조회(상품 형태, 대표상품 정보 출력)", notes = "상품 형태 1~4번을 표현할 수 있는 정보가 포함됨<br/>리스트에 표현될 가격정보는 대표상품의 가격으로 설정(서브상품가격은 무시)")
    @GetMapping
    public ListResult<GoodsDTOForDCODE> findAllForDcode() {
        //return responseService.getListResult(ObjectMapperUtils.mapAll(goodsSaleShapeRepository.findAllByMasterGoodsYn(MasterGoodsYn.YES), GoodsDTOForDCODE.class));
        GoodsConditionForDCODE condition = new GoodsConditionForDCODE();
        condition.setMasterGoodsYn(MasterGoodsYn.YES);
        return responseService.getListResult(qGoodsSaleShapeRepository.search(condition));
    }

    @ApiOperation(value = "특정 상품 판매 상세 조회(특정 상품 판매 정보의 모든 내용 조회)", notes = "상품 4번(옵션구매상품)일 경우 옵션 상품은 선택 할 수 있는 구조<br/>상품 형태 3번(묶음상품) 혹은 4번(옵션구매상품)일 경우 서브 상품의 정보는 목록에 표현되는 정보 수준으로 포함")
    @GetMapping("/{goodsSaleSeq}")
    //public ListResult<GoodsDTOForDCODE> findByGoodsSaleSeqForDcode(GoodsConditionForDCODE condition) {
    public ListResult<GoodsDTOForDCODE> findByGoodsSaleSeqForDcode(@PathVariable("goodsSaleSeq") Integer goodsSaleSeq) {
        //return responseService.getListResult(ObjectMapperUtils.mapAll(goodsSaleShapeRepository.findAllByGoodsSaleGoodsSaleSeq(goodsSaleSeq), GoodsDTOForDCODE.class));
        GoodsConditionForDCODE condition = new GoodsConditionForDCODE();
        condition.setGoodsSaleSeq(goodsSaleSeq);
        List<GoodsDTOForDCODE> rtnList = qGoodsSaleShapeRepository.search(condition);
        if(rtnList.size()==0){
            throw new CResourceNotExistException();
        }
        return responseService.getListResult(qGoodsSaleShapeRepository.search(condition));


    }
}
