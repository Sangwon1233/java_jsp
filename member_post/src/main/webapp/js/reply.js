// const replyService =  {};
const  replyService = (function() {// 함수내부에서 결과 관리 위에랑 같은것
    const url = "/member_post/reply";
    
    function write(reply , callback){
        console.log(reply);
		if(callback)
			callback();

    }
    function list(pno,callback) {
        $.getJSON(url + "/list/" + pno).done(function(data) {
            if(callback)
            callback(data);
        });
        // $.ajax({
        //     url : url + "/list/" +pno,
        //     method : 'GET',
        //     dataType : 'JSON',
        //     succes : function(data) {
        //         console.log(data);

        //     }
        // })
    }
    return {write, list}
})();