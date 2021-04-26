con.setAutoCommit( false);
try{

	//Preparedtstatement pstmt=con.prepareStatement(sql);
	//pstmt.executeUpdate();
	//pstmet.executeUpdate();
	//....
	userAccountDao.update();
        logsDao.insert();


	con.commit();
}catch(Exception ex){
	 con.rollback();
}finally{
       con.setAutoCommit(true);
}


