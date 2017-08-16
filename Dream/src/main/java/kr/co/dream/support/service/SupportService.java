package kr.co.dream.support.service;

import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;

public interface SupportService {
	public ShippingItemsVO supportRegister(SupportVO supportVO);
	public SupportVO get_supportInfo(int support_no, int shipping_address_no);
}
