
	//主表格提交
	function main_form_submit(form_name) {

		$.post($('#Context_Submit_From').attr("action"), $('#Context_Submit_From').serialize(), function(res) {
			if(!res.status) {
				$.messager.show({
					title: '错误提示',
					msg: res.info,
					timeout: 2000,
					showType: 'slide'
				});
			} else {
				$.messager.show({
					title: '成功提示',
					msg: res.info,
					timeout: 1000,
					showType: 'slide'
				});
				//			UpdateTabs(Model_name, res.url+'&cachedata='+new Date().getTime(), '', 'iconfont icon-viewlist');
				$('#Context_id').val(res.id); //赋值新增的信息的ID号
				//按钮控制代码
				$('#main_save_btn').linkbutton('disable');
				//				$('#text_add_btn').linkbutton('enable');
			}
		})

	}
	//文本信息新增
	function text_data_add(id=0,title='',context='',o=null) {
		layer.open({
			title: '文本信息',
			type: 1,
			area: ['400px', '300px'],
			content: '<table cellpadding="2" cellspacing="2" width="100%"><tbody>'+
				'<tr><td>标题:</td><td><input type="text" class="input" id="text_title" value="'+title+'" style="width:200px;"></td></tr>' +
				'<tr><td>内容:</td><td><textarea type="text" class="input" id="text_context" style="width:280px;height:150px;">'+context+'</textarea></td></tr>' +
				'</table>',
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				var title = $('#text_title').val();
				var context = $('#text_context').val();
				var refno = $('#Context_id').val(); //信息的主键
				if(title.trim() == '') {
					layer.alert('请填写标题！', {
						icon: 7
					});
					return false;
				}
				if(context.trim() == '') {
					layer.alert('请填写内容！', {
						icon: 7
					});
					return false;
				}

				$.post(itemHanlerUrl, {
					"refno": refno,
					"title": title,
					"context": context,
					"id":id,
					"type":1
				}, function(data) {
					var json = eval(data);
					//					console.log(json);
					if(json.status) {
						layer.msg('文本信息添加成功！');
						var tr = document.createElement('tr');
						if(id !=0){//如果是编辑
							$(o).parent().prev().html(context.substr(0, 40)+"..."); 
							$(o).parent().prev().prev().html(title);
						}else{
						tr.innerHTML = "<td>" + title + "</td>" +
							'<td>' + context.substr(0, 40) + '...</td>' +
							"<td><a  href='#' onclick=\"record_text_edit(this," + json.id + ")\">编辑</a>&nbsp;<a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
						$('#text_body').append(tr);
						}
						//$(o).parent().prev().prev().prev().prev().prev().prev().html('<span class="label label-info">已发货</span>');

					} else {
						layer.msg(json.info);
					}
				});

				//按钮【按钮一】的回调
				layer.close(index); //如果设定了yes回调，需进行手工关闭
			}
		});
	}
	//文本信息编辑
	function record_text_edit(o,id){
		$.post(getItemUrl, {
			"id": id
		}, function(data) {
			var json = eval(data);
			//debugger;
			text_data_add(id,json.title,json.context,o);
		});
	}
	//图片信息新增
	function pic_data_add(id=0,title='',savepath='',image='',isshow=0,o=null) {
		var refno = $('#Context_id').val(); //信息的主键
		layer.open({
			title: '图片信息',
			type: 2,
			area: ['800px', '600px'],
			content: picUploadUrl+"&savepath="+savepath+"&image="+image+"&title="+title+"&isshow="+isshow,
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				debugger;
				var body = layer.getChildFrame('body', index);
				var savepath = body.find('#item_savepath').val();
				var image = body.find('#item_image').val();
				if(image == '') {
					layer.msg('请上传图片！');
				} else {
					var title = body.find('#item_title').val();
					var isshow = body.find('#item_isshow').val();
					$.post(itemHanlerUrl, {
						"refno": refno,
						"title": title,
						"savepath": savepath,
						"image": image,
						"isshow":isshow,
						'id':id,
						"type":2
					}, function(data) {
						var json = eval(data);
						if(json.status) {
							layer.msg('图片信息添加成功！');
							if(id !=0){
								$(o).parent().prev().html(title);
								$(o).parent().prev().prev().html("<img src='"+_PUBLIC + savepath + image+"' style='width:40px;height:40px;'/>");
							}else{
							var tr = document.createElement('tr');
							tr.innerHTML = "<td><img src='"+_PUBLIC + savepath + image+"' style='width:40px;height:40px;'/></td>" +
								'<td>' + title + '</td>' +
								"<td><a  href='#' onclick=\"record_text_edit(this," + json.id + ")\">编辑</a>&nbsp;<a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
							$('#pic_body').append(tr);
							}
						} else {
							layer.msg(json.info);
						}
					});
					layer.close(index); //如果设定了yes回调，需进行手工关闭
				}
			}
		});
	}
	//编辑图片信息
	function record_image_edit(o,id){
		$.post(getItemUrl, {
			"id": id
		}, function(data) {
			var json = eval(data);
			//debugger;
			pic_data_add(id,json.title,json.savepath,json.image,json.isshow,o);
		});
	}
	//视频信息新增
	function video_data_add(id=0,title='',savepath='',image='',isshow=0,context='',o=null) {
		var refno = $('#Context_id').val(); //信息的主键
		layer.open({
			title: '视频信息',
			type: 2,
			area: ['800px', '600px'],
			content: videoUploadUrl+"&savepath="+savepath+"&image="+image+"&title="+title+"&isshow="+isshow+"&context="+context,
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				var body = layer.getChildFrame('body', index);
				var savepath = body.find('#item_savepath').val();
				var image = body.find('#item_image').val();
				if(image == '') {
					layer.msg('请上传图片！');
				} else {
					var title = body.find('#item_title').val();
					var context = body.find('#item_context').val();
					var isshow = body.find('#item_isshow').val();
					$.post(itemHanlerUrl, {
						"refno": refno,
						"title": title,
						"savepath": savepath,
						"image": image,
						"context":context,
						"isshow":isshow,
						"type":3
					}, function(data) {
						var json = eval(data);
						if(json.status) {
							layer.msg('视频信息添加成功！');
							if(id !=0){
								$(o).parent().prev().html(title);
								$(o).parent().prev().prev().html("<img src='"+_PUBLIC + savepath + image+"' style='width:40px;height:40px;'/>");
							}else{
							var tr = document.createElement('tr');
							tr.innerHTML = "<td><img src='"+_PUBLIC + savepath + image+"' style='width:40px;height:40px;'/></td>" +
								'<td>' + title + '</td>' +
								"<td><a  href='#' onclick=\"record_text_edit(this," + json.id + ")\">编辑</a>&nbsp;<a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
							$('#pic_body').append(tr);
							}
						} else {
							layer.msg(json.info);
						}
					});
					layer.close(index); //如果设定了yes回调，需进行手工关闭
				}
			}
		});
	}
	//编辑图片信息
	function record_video_edit(o,id){
		$.post(getItemUrl, {
			"id": id
		}, function(data) {
			var json = eval(data);
			//debugger;
			video_data_add(id,json.title,json.savepath,json.image,json.isshow,json.context,o);
		});
	}
	function record_delete(o, id) {
		layer.confirm('你确定要删除此记录吗？', {
			btn: ['确定', '取消'] //按钮
		}, function() {
			layer.closeAll();
			$.post(itemDeleteUrl, {
				"id": id
			}, function(data) {
				var json = eval(data);
				if(json.status) {
					layer.msg('删除成功！');
					$(o).parent().parent().remove(); //界面删除这行
				} else {
					layer.msg(json.info);
				}
			});
		});

	}