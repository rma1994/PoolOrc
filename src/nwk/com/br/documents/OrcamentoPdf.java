/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.documents;

/**
 *
 * @author Richard Matheus
 */
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import nwk.com.br.dao.ClienteDAO;
import nwk.com.br.dao.OrcamentoDAO;
import nwk.com.br.model.Cliente;
import nwk.com.br.model.Orcamento;
import nwk.com.br.model.Produto;
  
    public class OrcamentoPdf {
        OrcamentoDAO orcamentodao = new OrcamentoDAO();
        Orcamento orcamento = new Orcamento();
        Cliente cliente = new Cliente();
        ClienteDAO clientedao = new ClienteDAO();
        
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        
        
        public void gerarPdf(Orcamento orcamento) throws Exception {
            Document doc = null;
            OutputStream os = null;
            cliente = clientedao.select(orcamento.getIdCliente());
            
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 35, 35, 35, 35);
                
                //cria a stream de saída
                os = new FileOutputStream("C:\\PoolOrc\\OrcPdf\\ORC" + orcamento.getId() + " " + cliente.getNome() + ".pdf");
  
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);
  
                //abre o documento
                doc.open();
                
                //Definindo a font coamily.COURIER, 20, Font.BOLD);mo Courier, tamanho 20 em negrito
                //Font f = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
                Paragraph orc = new Paragraph("ORÇAMENTO",f);
                orc.setAlignment(Element.ALIGN_CENTER);
                
                /*AREA DE TESTES**************************************************/
                
                
                
                /*AREA DE TESTES**************************************************/
                
                
                doc.add(numPed(orcamento));//adiciona numero do pedido
                doc.add(new Paragraph(" "));
                doc.add(cabecalho(orcamento));//adiciona o cabecalho com informações da empresa
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(dadosCliente(orcamento));//adiciona os dados do cliente
                doc.add(new Paragraph(" "));
                doc.add(orc);//esreve orçamento
                doc.add(new Paragraph(" "));
                doc.add(dadosProdutos(orcamento));//adiciona os produtos
                //doc.add(new Paragraph(" "));
                doc.add(new Paragraph("______________________________________________________________________________"));
                //doc.add(new Paragraph(" "));
                doc.add(dadosPagamento(orcamento));//adiciona os dados de valores e forma de pagamento
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(dadosRodape(orcamento));//adiciona o rodape ao orçamento
                
  
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();
                }
            }
            System.out.println("done");
        }
        
        
        //Pega o Id do orçamento
        private Paragraph numPed(Orcamento orcamento) throws Exception{
            //cria uma linha com o numero do pedido
            Paragraph cod = new Paragraph("Orçamento: " + orcamento.getId(),f);
            cod.setAlignment(Element.ALIGN_RIGHT);
            return cod;
        }
        
        
        //Adiciona o cabecalho do orcamento
        private PdfPTable cabecalho(Orcamento orcamento) throws Exception{

            //Cria Uma nova tabela com tres colunas, onde cada uma ocupa 20%, 20% e 60% do tamanho delas
            PdfPTable cabecalho = new PdfPTable(new float[] { 0.3f, 0.4f, 0.3f });
            cabecalho.setWidthPercentage(100.0f);//seta o tamanho da tabela em relaçao ao documento
            cabecalho.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.getDefaultCell().setBorder(0);
            
            //Instancia a imagem da logo da empresa
            Image img = Image.getInstance("logoorc.png");//instancia a imagem
            img.setAlignment(Element.ALIGN_CENTER);//alinha a imagem no centro

            //Cria uma linha da tabela que pegara 3 linhas com a logo nela
            PdfPCell logo = new PdfPCell(img);
            logo.setBorder(0);
            logo.setRowspan(3);
            
            //adiciona a logo a tabela
            cabecalho.addCell(logo);
            
            //adiciona informações da empresa a tabela
            cabecalho.addCell(new Phrase(new Chunk("Sos da Piscina",f)));
            cabecalho.addCell(new Phrase(new Chunk(formatDate.format(orcamento.getDhOrcamento()).toString(),f)));
            cabecalho.addCell(new Phrase(new Chunk("Avenida Rebouças, 1440 - Centro",f)));
            cabecalho.addCell(new Phrase(new Chunk("Sumaré/SP - 13170-140",f)));
            cabecalho.addCell(new Phrase(new Chunk("contato@sosdapiscina.com.br",f)));
            cabecalho.addCell(new Phrase(new Chunk("www.sosdapiscina.com.br",f)));
            cabecalho.addCell(new Phrase(new Chunk("",f)));
                
            return cabecalho;
        }
        
        
        //Adiciona os dados do cliente do orcamento
        private PdfPTable dadosCliente(Orcamento orcamento) throws Exception{
            cliente = clientedao.select(orcamento.getIdCliente());
            
            
            PdfPTable dadosCliente = new PdfPTable(new float[] { 0.4f, 0.3f, 0.3f });
            dadosCliente.setWidthPercentage(90.0f);//seta o tamanho da tabela em relaçao ao documento
            dadosCliente.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);//alinha os dados a esquerda
            dadosCliente.getDefaultCell().setBorder(0);//retira a borda
            
            //Cria uma cedula da tabela que pegara tres colunas
            PdfPCell nomeCli = new PdfPCell(new Paragraph("Nome: " + cliente.getNome(),f));
            nomeCli.setColspan(3);
            nomeCli.setHorizontalAlignment(Element.ALIGN_LEFT);
            nomeCli.setBorder(0);
            dadosCliente.addCell(nomeCli);
            
            //adciona os demais dados do cliente a tabela
            dadosCliente.addCell("E-mail: " + cliente.getEmail());
            dadosCliente.addCell("Telefone: " + cliente.getTelefone());
            dadosCliente.addCell("Celular: " + cliente.getCelular());
            dadosCliente.addCell("Rua: " + cliente.getRua() + ", " + cliente.getNumero());
            dadosCliente.addCell("Bairro: " + cliente.getBairro());
            dadosCliente.addCell("Complemento: " + cliente.getComplemento());
            dadosCliente.addCell(cliente.getCidade() + "/" + cliente.getEstado());
            dadosCliente.addCell(cliente.getCep());
            
            return dadosCliente;
        }
        
        
        //Adiciona os dados dos produtos
        private PdfPTable dadosProdutos(Orcamento orcamento) throws Exception{
            PdfPTable produtosOrc = new PdfPTable(new float[] { 0.1f/*cod*/, 0.45f/*descri*/, 0.1f/*qtd*/, 0.2f/*valuni*/, 0.15f/*descon*/, 0.2f/*total*/ });
            produtosOrc.setWidthPercentage(100.0f);//seta o tamanho da tabela em relaçao ao documento
            produtosOrc.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            produtosOrc.getDefaultCell().setBorder(0);
            
            //Adiciona os nomes das colunas
            PdfPCell codProd = new PdfPCell(new Paragraph("Cod"));
            PdfPCell descProd = new PdfPCell(new Paragraph("Descrição"));
            PdfPCell qtdProd = new PdfPCell(new Paragraph("Qtd"));
            PdfPCell valProd = new PdfPCell(new Paragraph("Valor Unitario"));
            PdfPCell desProd = new PdfPCell(new Paragraph("Desconto"));
            PdfPCell totalProd = new PdfPCell(new Paragraph("Total"));

            produtosOrc.addCell(codProd);
            produtosOrc.addCell(descProd);
            produtosOrc.addCell(qtdProd);
            produtosOrc.addCell(valProd);
            produtosOrc.addCell(desProd);
            produtosOrc.addCell(totalProd);

            //Adiciona as informações dos produtos na tabela
            for(Produto produto : orcamentodao.getTodosProdutosOrcamento(orcamento)){
                produtosOrc.addCell(produto.getId());
                produtosOrc.addCell(produto.getDescricao());
                produtosOrc.addCell(produto.getQuantidade());
                produtosOrc.addCell("R$ " + produto.getValorVenda());
                produtosOrc.addCell("R$ " + produto.getDesconto());
                produtosOrc.addCell("R$ " + produto.getTotal());
            }
            
            return produtosOrc;
        }
        
        
        //Adiciona os dados de valores
        private PdfPTable dadosPagamento(Orcamento orcamento) throws Exception{
            Font fontTotal = new Font(Font.FontFamily.TIMES_ROMAN, 16);

            PdfPTable dPagamento = new PdfPTable(new float[] { 0.5f, 0.2f, 0.3f});
            dPagamento.setWidthPercentage(100.0f);//seta o tamanho da tabela em relaçao ao documento
            dPagamento.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            dPagamento.getDefaultCell().setBorder(0);

            //celula com espaço em branco e com o Total
            PdfPCell spc = new PdfPCell(new Paragraph(" "));
            PdfPCell total = new PdfPCell(new Paragraph("TOTAL: R$" + orcamento.getTotal(),fontTotal));

            //alinha a celula total a esquerda
            total.setHorizontalAlignment(Element.ALIGN_RIGHT);

            spc.setColspan(3);

            total.setBorder(0);
            spc.setBorder(0);

            dPagamento.addCell(new Paragraph("Forma de Pagamento: " + orcamento.getFormaPagamento(),f));
            dPagamento.addCell(new Paragraph("Desconto: R$" + orcamento.getDesconto(),f));
            dPagamento.addCell(total);

            return dPagamento;
        }
    
        
        //Adiciona o rodape
        private PdfPTable dadosRodape (Orcamento orcamento) throws Exception{
            //tabela que pega com 100% do tamanho do arquivo, alinhada no centro com tres colunas e sem bordas
            PdfPTable rodape = new PdfPTable(new float[] { 0.5f, 0.2f, 0.3f});
            rodape.setWidthPercentage(100.0f);//seta o tamanho da tabela em relaçao ao documento
            rodape.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            rodape.getDefaultCell().setBorder(0);
            
            PdfPCell obs = new PdfPCell(new Paragraph("\n\n Observações:\n" + orcamento.getObservacoes(),f));
            PdfPCell ass = new PdfPCell(new Paragraph("\n\n_________________________\nAssinatura",f));
            
            Font fonteAviso = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.BOLDITALIC);
            
            PdfPCell spc = new PdfPCell(new Paragraph(" "));
            PdfPCell aviso = new PdfPCell(new Paragraph("AGRADEÇEMOS A PREFERÊNCIA\nORÇAMENTO VALIDO SOMENTE PARA O DIA DE SUA CRIAÇÃO!",fonteAviso));
            
            aviso.setHorizontalAlignment(Element.ALIGN_CENTER);
            obs.setHorizontalAlignment(Element.ALIGN_LEFT);
            ass.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            obs.setBorder(0);
            ass.setBorder(0);
            spc.setBorder(0);
            aviso.setBorder(0);
            
            spc.setColspan(3);
            aviso.setColspan(3);
            
            rodape.addCell(obs);
            rodape.addCell(new Paragraph(" "));
            rodape.addCell(ass);
            rodape.addCell(spc);
            rodape.addCell(spc);
            rodape.addCell(spc);
            rodape.addCell(spc);
            rodape.addCell(aviso);
            //rodape.setExtendLastRow(true);
            
            //cria uma nova celula que recebe a tabela anterior
            PdfPCell otherCell = new PdfPCell(rodape);
            otherCell.setBorder(0);
            otherCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            otherCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            //cria uma nova tabela que recebe a celula otherCell
            PdfPTable rodape2 = new PdfPTable(new float[] {1.0f});
            rodape2.setWidthPercentage(100.0f);//seta o tamanho da tabela em relaçao ao documento
            
            rodape2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            rodape2.getDefaultCell().setBorder(0);
            
            //estende a tabela até o fim da pagina, como o alinhamento horizontal dela é bottom, ela fica toda no rodape
            rodape2.addCell(otherCell);
            rodape2.setExtendLastRow(true);
            
            return rodape2;
        }
    }
