$(document).ready(function(){

	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url : "/board_list_json_data/"+page+"/",
			success : function(result){

				//dhtml을 활용하여 테이블로 출력
				let code = "<table class='board_list'>";
				code += "<tr><td colspan= '5'>";
				code += "<a href='/board_write'>";
				code += "<button type='button' class='btn_style2'>글쓰기</button>";
				code += "</a></td></tr>";
				code += "<tr><th>번호</th><th>제목</th><th>조회수</th><th>작성자</th><th>작성일자</th></tr>";
				for(obj of result.list) {
					code += "<tr>";
					code += "<td>" + obj.rno + "</td>";
					code += "<td class = 'btitle' id = '" + obj.bid + "' style = 'cursor:pointer'><a>" + obj.btitle + "</a></td>";
					code += "<td>" + obj.bhits + "</td>";
					code += "<td>" + obj.id + "</td>";
					code += "<td>" + obj.bdate + "</td>";
					code += "</tr>";
				}
				code += "<tr>";
				code += "<td colspan='5'><div id='ampaginationsm'></div></td>";
				code += "</tr>";
				code += "</table>";
				
				//code를 출력
				$("table.board_list").remove();
				$("h1").after(code);

				//content(상세보기) 이벤트 처리
				$(".btitle").click(function(){
					contentAjax($(this).attr("id"), page);
				})


				//페이징 처리 함수 호출		
				pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);
				
				//페이징 번호 클릭 이벤트 처리
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   		jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           		//$(location).attr('href', "http://localhost:9000/board_list_json.do?page="+e.page);         
			   		initAjax(e.page);
	  			});
	  			
			}//success
		
		});//ajax
	}//initAjax
	
	
	/* 페이징 처리 함수 */
	function pager(totals, maxSize, pageSize, page){
		//alert(totals + "," + maxSize + "," + pageSize + "," + page);
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page		
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
	}

	function contentAjax(bid, page) {
		//alert("bid-->" + bid + ", page--> " + page);

		$.ajax({
			url: "board_content_json_data/" + bid + "/" ,
			success: function(board) {
				let code = "<table class='board_content'>"
				code += "<tr><th>제목</th><td>" + board.btitle + "</td></tr>";
				code += "<tr><th>내용</th><td>" + board.bcontent + "";
				if(board.bsfile != null) {
					code += "<br><br><br><img src = 'http://localhost:9000/upload/" + board.bsfile + "'>";
				}
				code += "</td></tr>";
				code += "<tr><th>조회수</th><td>" + board.bhits + "</td></tr>";
				code += "<tr><th>작성자</th><td>" + board.id + "</td></tr>";
				code += "<tr><th>작성일자</th><td>" + board.bdate + "</td></tr>";
				code += "<tr><td colspan = '2'>";
				code += "<button>수정하기</button>";
				code += "<button>삭제하기</button>";
				code += "<button class = 'btnBoardList'>리스트</button>";
				code += "<button class = 'btnHome'>홈으로</button>";
				code += "</td></tr>";
				code += "</table>";
				$("table.board_list").remove();
				$("h1").after(code);

				$(".btnBoardList").click(function(){
					$("table.board_content").remove();
					initAjax(page);
				})
				$(".btnHome").click(function() {
					location.href = "/";
				})
			}//success
		})//ajax
	}


}); //ready