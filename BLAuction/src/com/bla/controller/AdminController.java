package com.bla.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.AuctionBiz;
import com.bla.biz.BiddingBiz;
import com.bla.biz.MemberBiz;
import com.bla.biz.PhotoBiz;
import com.bla.biz.SuccessfulBidBiz;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;
import com.bla.vo.ListVO;
import com.bla.vo.MemberVO;
import com.bla.vo.PhotoVO;

@Controller
public class AdminController {
	@Resource(name = "abiz")
	AuctionBiz abiz;

	@Resource(name = "pbiz")
	PhotoBiz pbiz;

	@Resource(name = "bbiz")
	BiddingBiz bbiz;

	@Resource(name = "sbiz")
	SuccessfulBidBiz sbiz;

	@Resource(name = "mbiz")
	MemberBiz mbiz;
	
	// 전체리스트
	@RequestMapping("/admin.bla")
	@ResponseBody
	public ModelAndView allList(HttpServletRequest request) {
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				newlist.setAuction(auctionVO);
				newlist.setDuedate(due_date);
				newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auctionVO.getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET ALL ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Status
	@RequestMapping("/admin_status.bla")
	@ResponseBody
	public ModelAndView auction_status(HttpServletRequest request) {
		String status = request.getParameter("status");
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getAuction_status().equals(status)) {
					ListVO newlist = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					newlist.setAuction(auctionVO);
					newlist.setDuedate(due_date);
					newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (newlist.getMax_price() == null) {
						newlist.setMax_price(auctionVO.getStart_price());
					}
					list.add(newlist);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY STATUS ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Category
	@RequestMapping("/admin_category.bla")
	@ResponseBody
	public ModelAndView auction_category(HttpServletRequest request) {
		int category = Integer.parseInt(request.getParameter("id"));
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getCategory_id() == category) {
					ListVO newlist = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					newlist.setAuction(auctionVO);
					newlist.setDuedate(due_date);
					newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (newlist.getMax_price() == null) {
						newlist.setMax_price(auctionVO.getStart_price());
					}
					list.add(newlist);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY CATEGORY ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Type
	@RequestMapping("/admin_type.bla")
	@ResponseBody
	public ModelAndView auction_type(HttpServletRequest request) {
		int type = Integer.parseInt(request.getParameter("id"));
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getType() == type) {
					ListVO newlist = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					newlist.setAuction(auctionVO);
					newlist.setDuedate(due_date);
					newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (newlist.getMax_price() == null) {
						newlist.setMax_price(auctionVO.getStart_price());
					}
					list.add(newlist);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY TYPE ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Unconfirmed Auction
	@RequestMapping("/admin_unconfirmed_auction.bla")
	@ResponseBody
	public ModelAndView auction_unconfirmed(HttpServletRequest request) {
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getAuction_address() == null) {
					ListVO newlist = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					newlist.setAuction(auctionVO);
					newlist.setDuedate(due_date);
					newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (newlist.getMax_price() == null) {
						newlist.setMax_price(auctionVO.getStart_price());
					}
					list.add(newlist);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET UNCONFIRMED AUCTIONS ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Unconfirmed Bidding
	@RequestMapping("/bidding_unconfirmed_auction.bla")
	@ResponseBody
	public ModelAndView bidding_unconfirmed(HttpServletRequest request) {
		ArrayList<BiddingVO> bidding_list = null;
		ArrayList<ListVO> list = new ArrayList<ListVO>();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			bidding_list = bbiz.get();
			Iterator<BiddingVO> itr = bidding_list.iterator();
			while (itr.hasNext()) {
				BiddingVO biddingVO = (BiddingVO) itr.next();
				if(biddingVO.getBid_conf_status() == 0) {
					ListVO listVO = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) biddingVO.getTime()));
					listVO.setDuedate(due_date);
					listVO.setBidding(biddingVO);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/bidding");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/bidding");
		}
		
		System.out.println("###################### GET UNCONFIRMED BIDDING ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Members
		@RequestMapping("/admin_member.bla")
		@ResponseBody
		public ModelAndView member(HttpServletRequest request) {
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();

			ModelAndView mv = new ModelAndView();
			mv.setViewName("admin");
			try {
				list = mbiz.get();
				mv.addObject("list", list);
				mv.addObject("centerpage", "admin/member");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("centerpage", "admin/member");
			}
			
			System.out.println("###################### GET MEMBERS ######################");
			Iterator<MemberVO> itr_ = list.iterator();
			while (itr_.hasNext()) {
				MemberVO member = (MemberVO) itr_.next();
				System.out.println(member);
			}

			return mv;
		}
		
	// Auction Detail
	@RequestMapping("/admin_auction_detail.bla")
	@ResponseBody
	public ModelAndView auction_details(HttpServletRequest request) {
		int auction_id = Integer.parseInt(request.getParameter("id"));
		ArrayList<BiddingVO> bidding_list = null;
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<PhotoVO> photos = null;
		AuctionVO auction = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction = abiz.get(auction_id);
			
			// Getting Due Date
			String auction_due_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분")
					.format(new Date((Long) auction.getDuedate()));
			
			// Getting Due Date
			String auction_register_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분")
					.format(new Date((Long) auction.getRegister_date()));
			
			// Calculate Current Price 
			Long cur_priceL = bbiz.selectBidMaxPrice(auction);
			if (cur_priceL == null) {
				cur_priceL = auction.getStart_price();
			}
			Double cur_price = cur_priceL.doubleValue();
			cur_price = Math.round(cur_price * 1000) / 1000.0;
			
			// Getting Bidding List 
			bidding_list = bbiz.selectAuctionBiddingList(auction_id);
			Iterator<BiddingVO> itr = bidding_list.iterator();
			while (itr.hasNext()) {
				BiddingVO biddingVO = (BiddingVO) itr.next();
				ListVO listVO = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) biddingVO.getTime()));
				listVO.setDuedate(due_date);
				listVO.setBidding(biddingVO);
			}
			
			photos = pbiz.getAll(auction_id);
			if(!photos.isEmpty()) {
				mv.addObject("photo1", photos.get(0).getPhoto_path() + photos.get(0).getPhoto_name());
				if(photos.size() == 2)
				mv.addObject("photo2", photos.get(1).getPhoto_path() + photos.get(1).getPhoto_name());
			}
			
			mv.addObject("due_date", auction_due_date);
			mv.addObject("register_date", auction_register_date);
			mv.addObject("cur_price", cur_price);
			mv.addObject("auction", auction);
			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/auction_detail");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/auction_detail");
		}
		
		System.out.println("###################### Auction Detail ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
}