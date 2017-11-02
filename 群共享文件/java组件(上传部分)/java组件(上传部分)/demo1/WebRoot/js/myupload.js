function go()
	{				
					var go = "";
					var strfile=document.all.strfile.value;
					var strname=document.all.strname.value;
					var strsize=document.all.strsize.value;
					var cursize=document.all.cursize.value;
					var onesize=document.all.onesize.value;
					var sumsize=document.all.sumsize.value;
					var upmonth=document.all.upmonth.value;
					var savedir=document.all.savedir.value;
					var count=document.all.count.value;
					
					go = "./uploade/uploade.jsp?strfile="+ strfile +"&strname=" + strname + "&strsize="+strsize+"&onesize="+onesize+"&cursize="+cursize+"&sumsize=" + sumsize + "&upmonth=" + upmonth+"&savedir=" + savedir+"&count=" + count;
					var oawin = window.open(go,"_blank","toolbar=0,left=231,top=196,status=0,menubar=0,scrollbars=yes,resizable=1,width=600,height=300");
					oawin.focus();
					oawin.opener=window;
	}