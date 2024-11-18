// const replyService =  {};
const  replyService = (function() {// 함수내부에서 결과 관리 위에랑 같은것
    const url = "/member_post/reply";
    
    function write(reply , callback){
        console.log(reply);
		//relpy
        // JSON.stringify(arg) :: obj -> json String
        // JSON.pares(arg) :: json  ->  obj
        const data = JSON.stringify(reply);
        $.post({url,data})
        .done(function(data){
            console.log(data);
			if(callback)
				callback(data);
            
        })


    }
    function list(pno,callback) {
        $.getJSON(url + "/list/" + pno).done(function(data) {
            if(callback)
            callback(data);
        });
		
	}
	function view(rno, callback){
		$.getJSON(url + "/" +rno).done(function(data){
			if(callback)
				callback(data);
		})
	}	
        // $.ajax({
        //     url : url + "/list/" +pno,
        //     method : 'GET',
        //     dataType : 'JSON',
        //     succes : function(data) {
        //         console.log(data);

        //     }
        // })
    function modify(reply,callback){
		const data = JSON.stringify(reply);
		console.log(reply);
		$.ajax(url,{
			method : 'put',
			data
		}).done(function(data){
			console.log(data);
			if(callback)
			callback(data);
		})
	}
	function remove(rno,callback){
		console.log(rno);
		$.ajax(url + "/" +rno,{
			method : 'delete'
		}).done(function(data){
			 console.log(data);
			if(callback)
			callback(data);
		})
	}
    return {write,list,view,modify,remove}
})();