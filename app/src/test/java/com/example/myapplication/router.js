'use strict';

/**
 * @param {Egg.Application} app - egg application
 */
module.exports = async app => {
  const {router, controller} = app;

  /**
   * 保存包含（新增、修改）
   */

  //获取当前登录用户
  router.get('/auth', controller.auth.index);
  //登录
  router.post('/auth', controller.auth.login);
  //退出登录
  router.delete('/auth', controller.auth.logout);

  //用户列表查询
  router.get('/usermgr', controller.user.index)
  //用户保存
  router.post('/usermgr', controller.user.save)
  //用户删除
  router.delete('/usermgr', controller.user.del)
  //用户密码重置
  router.post('/usermgr/resetPwd', controller.user.resetPwd)
  //用户密码修改
  router.post('/usermgr/pwd', controller.user.pwd)
  //用户AP保存
  router.post('/usermgr/aps', controller.user.aps)
  //用户桌牌保存
  router.post('/usermgr/labels', controller.user.labels)

  //AP列表查询
  router.get('/apmgr', controller.ap.index)
  //AP保存
  router.post('/apmgr/save', controller.ap.save)
  //AP删除
  router.post('/apmgr/delete', controller.ap.delete)

  //桌牌列表查询
  router.get('/labelmgr', controller.label.index)
  //桌牌模糊查询
  router.get('/labelmgr/regex', controller.label.regex)
  //桌牌删除
  router.post('/labelmgr/delete', controller.label.delete)
  //桌牌导入
  router.post('/labelmgr/import', controller.label.import)

  //桌牌关联列表查询
  router.get('/cardmgr', controller.card.index)
  //桌牌关联保存
  router.post('/cardmgr/save', controller.card.save)
  //桌牌关联删除
  router.post('/cardmgr/delete', controller.card.delete)
  //桌牌关联导入
  router.post('/cardmgr/import', controller.card.import)

  //模板列表查询
  router.get('/templatemgr', controller.template.index)
  //模板保存
  router.post('/templatemgr', controller.template.save)
  //模板删除
  router.delete('/templatemgr', controller.template.del)

  //文件列表查询
  router.get('/file/:dir', controller.file.index)
  //文件删除
  router.delete('/file/:dir', controller.file.del)
  //文件上传
  router.post('/file/upload/:dir', controller.file.upload)

  //会议列表查询
  router.get('/meetingmgr', controller.meeting.index)
  //会议查询
  router.get('/meetingmgr/:_id', controller.meeting.findOne)
  //会议保存
  router.post('/meetingmgr/save', controller.meeting.save)
  //会议删除
  router.post('/meetingmgr/delete', controller.meeting.delete)

  //会议桌牌列表查询
  router.post('/meetingmgr/querycards', controller.meeting.queryCards)
  //会议桌牌保存
  router.post('/meetingmgr/savecards', controller.meeting.saveCards)
  //会议桌牌更新
  router.post('/meetingmgr/updatecards', controller.meeting.updateCards)
  //会议桌牌移除
  router.post('/meetingmgr/removecards', controller.meeting.removeCards)
  //会议桌牌同步
  router.post('/meetingmgr/synccards', controller.meeting.syncCards)
  //会议桌牌状态重置
  router.post('/meetingmgr/resetcards', controller.meeting.resetCards)

  //屏幕列表查询
  router.get('/screenmgr', controller.screen.index)
  //屏幕保存
  router.post('/screenmgr/save', controller.screen.save)
  //屏幕删除
  router.post('/screenmgr/delete', controller.screen.delete)
};
