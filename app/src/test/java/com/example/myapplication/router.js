'use strict';

/**
 * @param {Egg.Application} app - egg application
 */
module.exports = async app => {
  const {router, controller} = app;
  router.get('/auth', controller.auth.index);
  router.post('/auth', controller.auth.login);
  router.delete('/auth', controller.auth.logout);

  router.get('/usermgr', controller.user.index)
  router.post('/usermgr', controller.user.save)
  router.delete('/usermgr', controller.user.del)
  router.post('/usermgr/resetPwd', controller.user.resetPwd)
  router.post('/usermgr/pwd', controller.user.pwd)
  router.post('/usermgr/aps', controller.user.aps)
  router.post('/usermgr/labels', controller.user.labels)

  router.get('/apmgr', controller.ap.index)
  router.post('/apmgr/save', controller.ap.save)
  router.post('/apmgr/delete', controller.ap.delete)

  router.get('/labelmgr', controller.label.index)
  router.get('/labelmgr/regex', controller.label.regex)
  router.post('/labelmgr/delete', controller.label.delete)
  router.post('/labelmgr/import', controller.label.import)

  router.get('/cardmgr', controller.card.index)
  router.post('/cardmgr/save', controller.card.save)
  router.post('/cardmgr/delete', controller.card.delete)
  router.post('/cardmgr/import', controller.card.import)

  router.get('/templatemgr', controller.template.index)
  router.post('/templatemgr', controller.template.save)
  router.delete('/templatemgr', controller.template.del)

  router.get('/file/:dir', controller.file.index)
  router.delete('/file/:dir', controller.file.del)
  router.post('/file/upload/:dir', controller.file.upload)

  router.get('/meetingmgr', controller.meeting.index)
  router.get('/meetingmgr/:_id', controller.meeting.findOne)
  router.post('/meetingmgr/save', controller.meeting.save)
  router.post('/meetingmgr/delete', controller.meeting.delete)

  router.post('/meetingmgr/querycards', controller.meeting.queryCards)
  router.post('/meetingmgr/savecards', controller.meeting.saveCards)
  router.post('/meetingmgr/updatecards', controller.meeting.updateCards)
  router.post('/meetingmgr/removecards', controller.meeting.removeCards)
  router.post('/meetingmgr/synccards', controller.meeting.syncCards)
  router.post('/meetingmgr/resetcards', controller.meeting.resetCards)

  router.get('/screenmgr', controller.screen.index)
  router.post('/screenmgr/save', controller.screen.save)
  router.post('/screenmgr/delete', controller.screen.delete)
};
