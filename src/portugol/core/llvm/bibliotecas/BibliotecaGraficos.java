/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugol.core.llvm.bibliotecas;

import org.llvm.Module;
import org.llvm.TypeRef;
import portugol.core.llvm.Biblioteca;

/**
 *
 * @author Bernardo
 */
public class BibliotecaGraficos implements Biblioteca {
        
    @Override
    public String getNomePacote() {
        return (this.getClass().getPackage().getName() + "." + getClass().getName() + ".").replace(".", "_");
    }

    
    @Override
    public void inicializar(Module modulo) {
        String pacote = getNomePacote();
        //TODO: Implementar
        modulo.addFunction(pacote+"limpar", TypeRef
                .functionType(
                        TypeRef.voidType(), false /*retorno*/
                ));
        
        modulo.addFunction(pacote+"carregar_imagem", TypeRef
                .functionType(
                        TypeRef.int32Type(), false, /*retorno*/
                        TypeRef.int8Type().pointerType() /*caminho*/
                ));
        
        modulo.addFunction(pacote+"criar_cor", TypeRef
                .functionType(
                        TypeRef.int32Type(), false, /*retorno*/
                        TypeRef.int32Type(), /*vermelho*/
                        TypeRef.int32Type(), /*verde*/
                        TypeRef.int32Type()  /*azul*/
                ));
        
        modulo.addFunction(pacote+"definir_cor", TypeRef
                .functionType(
                        TypeRef.voidType(), false,/*retorno nulo*/
                        TypeRef.int32Type() /*cor*/
                ));
        
        modulo.addFunction(pacote+"desenhar_ponto", TypeRef
                .functionType(
                        TypeRef.voidType(), false,/*retorno nulo*/
                        TypeRef.int32Type(), /*x*/
                        TypeRef.int32Type()  /*y*/
                ));
        
        modulo.addFunction(pacote+"desenhar_imagem", TypeRef
                .functionType(
                        TypeRef.voidType(), false,/*retorno nulo*/
                        TypeRef.int32Type(), /*x*/
                        TypeRef.int32Type(),  /*y*/
                        TypeRef.int32Type()  /*endereço*/
                ));
        
        modulo.addFunction(pacote+"renderizar_imagem", TypeRef
                .functionType(
                        TypeRef.voidType(), false,/*retorno nulo*/
                        TypeRef.int32Type(), /*largura*/
                        TypeRef.int32Type()  /*altura*/
                ));
        
        modulo.addFunction(pacote+"renderizar", TypeRef
                .functionType(
                        TypeRef.int32Type(), false/*retorno nulo*/
                ));
        
        modulo.addFunction(pacote+"liberar_imagem", TypeRef
                .functionType(
                        TypeRef.int32Type(), false,/*retorno nulo*/
                        TypeRef.int32Type() /*endereço*/
                ));
        
        modulo.addFunction(pacote+"iniciar_modo_grafico", TypeRef
                .functionType(
                        TypeRef.voidType(), false,/*retorno nulo*/
                        TypeRef.int1Type() /*manter visível*/
                ));
        
        modulo.addFunction(pacote+"encerrar_modo_grafico", TypeRef
                .functionType(
                        TypeRef.voidType()
                ));
    }
    
}
