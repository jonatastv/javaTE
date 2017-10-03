package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;


public class TipoBancoDAO {
	
	public Conexao conexao = new Conexao();
    
	   public int incluiTipoBanco(TipoBanco c) throws SQLException
	    {
	        //retorna 0=> erro na inclusão
	        //        1=> incluiu
	        //        2=> registro cadastrado
	        int retorno=0;
	        String sql=null;
	        Connection conn= conexao.abreConexaoBD();
	        ResultSet rs;
	        Statement st = conn.createStatement();
	        String desc=c.getTipoBanco_sigla().trim();
	        sql="select * from tipos_bd where tip_sigla ='"+desc+"'";
	        rs = st.executeQuery(sql);
	        if (rs.next()==false)
	            retorno=0;
	        else
	            retorno=2; // possui cadastro
	        if (retorno==0)
	        {
	            sql="insert into tipos_bd (tip_sigla) values (";
	            sql+="'"+c.getTipoBanco_sigla()+"')";
	            int qRs= st.executeUpdate(sql);
	            if (qRs==0)
	                retorno=0;
	            else
	                retorno=1;
	        }
	        return retorno;
	    }
    
   public TipoBanco buscaTipoBancoPorId(int codigo)
            throws SQLException
    {
        TipoBanco a = new TipoBanco();
        String sql=null;
        sql="select * from tipos_bd where tip_id = "+codigo;
        Connection conn= conexao.abreConexaoBD();
        ResultSet rs = null;
        Statement st=null;
        st = conn.createStatement();
        rs= st.executeQuery(sql);
        if (rs.next())
        {
            a = new TipoBanco();
            a.setTipoBanco_id(rs.getInt("tip_id"));
            a.setTipoBanco_sigla(rs.getString("tip_sigla"));
            }
        else
     	   a=null;
        return a;
    }
    

  /* public TipoBanco excluirTipoID(int codigo)
           throws SQLException
   {
	   System.out.println("aquip");
       TipoBanco a = new TipoBanco();
       String sql=null;
       sql="delete from tipos_bd where tip_id = "+codigo;
       Connection conn= conexao.abreConexaoBD();
       ResultSet rs = null;
       Statement st=null;
       st = conn.createStatement();
       rs= st.executeQuery(sql);
       if (rs.next())
       {
    	   System.out.println("aqui");
    	  // sql="delete from tipos_bd where tip_id = "+codigo;
           a = new TipoBanco();
           a.setTipoBanco_id(rs.getInt("tip_id"));
           a.setTipoBanco_sigla(rs.getString("tip_sigla"));
           }
       else
    	   a=null;
       return a;
   }

   */
   
   public int excluirTipoID(TipoBanco c) throws SQLException
   {
       //retorna 0=> erro na inclusão
       //        1=> incluiu
       //        2=> registro cadastrado
       int retorno=0;
       String sql=null;
       Connection conn= conexao.abreConexaoBD();
       ResultSet rs;
       Statement st = conn.createStatement();
       String desc=c.getTipoBanco_sigla().trim();
       System.out.println(c.getTipoBanco_id());
      // sql="select * from tipos_bd where tip_sigla ='"+desc+"'";
    //   sql="delete from tipos_bd where tip_id="+c.getTipoBanco_id();
       sql="delete from tipos_bd where tip_id = "+c.getTipoBanco_id();
       
       int qRs= st.executeUpdate(sql);
       if (qRs==0)
           retorno=0;
      // rs = st.executeQuery(sql);
      // if (rs.next()==false)
        //   retorno=0;
     //  else
     //      retorno=2; // possui cadastro
    /*   if (retorno==0)
       {
           sql="delete from tipos_bd where tip_id"+c.getTipoBanco_sigla();
     
           int qRs= st.executeUpdate(sql);
           if (qRs==0)
               retorno=0;
           else
               retorno=1;
       } */
       return retorno;
   }
   
   
   
   
   public int alterar(TipoBanco c) throws SQLException
   {
       //retorna 0=> erro na inclusão
       //        1=> incluiu
       //        2=> registro cadastrado
       int retorno=0;
       String sql=null;
       Connection conn= conexao.abreConexaoBD();
       ResultSet rs;
       Statement st = conn.createStatement();
       String desc=c.getTipoBanco_sigla().trim();
       System.out.println(c.getTipoBanco_id());
      // sql="select * from tipos_bd where tip_sigla ='"+desc+"'";
    //   sql="delete from tipos_bd where tip_id="+c.getTipoBanco_id();
       sql="update tipos_bd set tip_sigla = "+"'"+c.getTipoBanco_sigla()+"'"+" where tip_id = "+c.getTipoBanco_id();
       
       int qRs= st.executeUpdate(sql);
       if (qRs==0)
           retorno=0;
      // rs = st.executeQuery(sql);
      // if (rs.next()==false)
        //   retorno=0;
     //  else
     //      retorno=2; // possui cadastro
    /*   if (retorno==0)
       {
           sql="delete from tipos_bd where tip_id"+c.getTipoBanco_sigla();
     
           int qRs= st.executeUpdate(sql);
           if (qRs==0)
               retorno=0;
           else
               retorno=1;
       } */
       return retorno;
   }
   
   
   }


