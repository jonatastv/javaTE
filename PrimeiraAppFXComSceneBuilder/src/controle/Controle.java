package controle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import com.sun.glass.events.MouseEvent;

import dao.TipoBancoDAO;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.TipoBanco;

public class Controle implements Initializable {

    @FXML
    private Button btnIncluir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtSigla;
    
    @FXML
    private ComboBox<String> comboTipo;
    
    @FXML
    private TextField txtBusca;

    @FXML
    private Button busca;
    
    @FXML
    void btnAlterarOnAction(ActionEvent event) throws SQLException {
    	 if (util.Util.stringVaziaOuNula(this.txtCodigo.getText())) {
  		   util.Util.mensagemErro("Informe do id banco de dados");
  	   } else {
  			TipoBanco tbd = new TipoBanco();
  		    TipoBancoDAO tbdDAO = new TipoBancoDAO();

  			if (!util.Util.stringVaziaOuNula(this.txtCodigo.getText()))
  				tbd.setTipoBanco_id(Integer.parseInt(this.txtCodigo.getText()));
  			tbd.setTipoBanco_sigla(this.txtSigla.getText());
  			int retorno = tbdDAO.alterar(tbd);
  			if (retorno == 1)
  				util.Util.mensagemInformacao("Inclusão realizada com sucesso");
  			if (retorno == 0)
  				util.Util.mensagemErro("Erro de Inclusão");
  			if (retorno == 2)
  				util.Util.mensagemInformacao("Registro já cadastrado");
    }
   }
   @FXML
    void btnExcluirOnAction(ActionEvent event) throws NumberFormatException, SQLException {
	   if (util.Util.stringVaziaOuNula(this.txtCodigo.getText())) {
		   util.Util.mensagemErro("Informe do id banco de dados");
	   } else {
			TipoBanco tbd = new TipoBanco();
		    TipoBancoDAO tbdDAO = new TipoBancoDAO();

			if (!util.Util.stringVaziaOuNula(this.txtCodigo.getText()))
				tbd.setTipoBanco_id(Integer.parseInt(this.txtCodigo.getText()));
			tbd.setTipoBanco_sigla(this.txtSigla.getText());
			int retorno = tbdDAO.excluirTipoID(tbd);
			if (retorno == 1)
				util.Util.mensagemInformacao("Inclusão realizada com sucesso");
			if (retorno == 0)
				util.Util.mensagemErro("Erro de Inclusão");
			if (retorno == 2)
				util.Util.mensagemInformacao("Registro já cadastrado");
			 
		
	   		}	
	   //this.limpaTela();

			 
	   }	
		   
    
   
   @FXML
   void btnBuscar(ActionEvent event) throws SQLException {
	   if (util.Util.stringVaziaOuNula(this.txtBusca.getText())) {
		   util.Util.mensagemErro("Informe do id banco de dados");
	   } else {
		   TipoBanco tbd = new TipoBanco();
		   TipoBancoDAO tbdDAO = new TipoBancoDAO();
		   

			if (!util.Util.stringVaziaOuNula(this.txtBusca.getText()))
				tbd.setTipoBanco_id(Integer.parseInt(this.txtBusca.getText()));

			tbd =	tbdDAO.buscaTipoBancoPorId(Integer.parseInt(this.txtBusca.getText()));
			 //util.Util.mensagemErro((this.txtBusca.getText()));
			 
			 this.txtCodigo.setText(Integer.toString(tbd.getTipoBanco_id()));
			 this.txtSigla.setText(tbd.getTipoBanco_sigla());
	   }	
   }

    @FXML
    void btnIncluirOnAction(ActionEvent event) throws SQLException {
		if (util.Util.stringVaziaOuNula(this.txtSigla.getText())) {
			util.Util.mensagemErro("Informe a sigla do tipo de banco de dados");
			
		}
		else
		{
				TipoBanco tbd = new TipoBanco();
			    TipoBancoDAO tbdDAO = new TipoBancoDAO();
	
			if (!util.Util.stringVaziaOuNula(this.txtCodigo.getText()))
				tbd.setTipoBanco_id(Integer.parseInt(this.txtCodigo.getText()));
			tbd.setTipoBanco_sigla(this.txtSigla.getText());
			int retorno = tbdDAO.incluiTipoBanco(tbd);
			if (retorno == 1)
				util.Util.mensagemInformacao("Inclusão realizada com sucesso");
			if (retorno == 0)
				util.Util.mensagemErro("Erro de Inclusão");
			if (retorno == 2)
				util.Util.mensagemInformacao("Registro já cadastrado");
	   }	
		this.limpaTela();

    	

    }
    
    public void limpaTela()
	{
		this.txtCodigo.setText("");
		this.txtSigla.setText("");
	}

 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	    comboTipo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()   		
        {
            public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue)
	    	{
	    	    util.Util.mensagemInformacao("Você selecionou o item "+ newvalue);
	    		
	    	}});
	    		

		
	    txtSigla.focusedProperty().addListener((v, vv, nv) -> {
	           if (!nv) 
	           { // perde o foco
	        	 //util.Util.mensagemErro("desfocou");
	           }
	           else
	           {
	        	   //System.out.println("*");
	           }

        });	
	   alimentaComboTipo();
	
	
	}
  
	public void alimentaComboTipo()
    {
       comboTipo.getItems().clear();//limpando a combobox
       comboTipo.getItems().add("MySql");
       comboTipo.getItems().add("Oracle");
       comboTipo.getItems().add("SQL Server");
       comboTipo.getItems().add("Postgres");
		
		
	
    }
}
