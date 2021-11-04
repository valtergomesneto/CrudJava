
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valte
 */
public class Principal extends javax.swing.JFrame {
    
    ArrayList<Departamento> ListaDep;
    ArrayList<Funcionario> ListaFunc;
    String modoDep;
    String modoFunc;
    public void LoadTableDep(){
        Object Colunas[] = {"Código", "Nome"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        
        for (int i = 0;i<ListaDep.size();i++){
            Object linha[] = new Object[]{ListaDep.get(i).getCodigo(), 
                                       ListaDep.get(i).getNome()};
            modelo.addRow(linha);
        }
        
        tbl_dep_dpts.setModel(modelo);
        tbl_dep_dpts.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_dep_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);
        LoadCbDep();
    }
    
    public void LoadTableFunc(){
        Object Colunas[] = {"Matricula", "Nome", "Departamento"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        
        for (int i = 0;i<ListaFunc.size();i++){
            Object linha[] = new Object[]{ListaFunc.get(i).getMatricula(), 
                                       ListaFunc.get(i).getNome(),
                                       ListaFunc.get(i).getDep().getNome()};
            modelo.addRow(linha);
        }
        
        tbl_func_funcs.setModel(modelo);
        tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        LoadCbDep();
    }
    
    public void LoadCbDep(){
        cb_func_deps.removeAllItems();
        cb_func_deps.addItem("Selecione:");
        for (int i = 0;i<ListaDep.size();i++){
            cb_func_deps.addItem(ListaDep.get(i).getNome());
        }
        
        
    }

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaDep = new ArrayList();
        ListaFunc = new ArrayList();
        modoDep = "Navegar";
        modoFunc = "Navegar";
        ManipulaInterfaceDep();
        ManipulaInterfaceFunc();
    }
    
    public void ManipulaInterfaceDep(){
        switch(modoDep){
            case "Navegar":
                txt_dep_codigo.setEnabled(false);
                txt_dep_nome.setEnabled(false);
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Novo":
                txt_dep_codigo.setEnabled(true);
                txt_dep_nome.setEnabled(true);
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Editar":
                txt_dep_codigo.setEnabled(true);
                txt_dep_nome.setEnabled(true);
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                txt_dep_codigo.setEnabled(false);
                txt_dep_nome.setEnabled(false);
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                txt_dep_codigo.setEnabled(false);
                txt_dep_nome.setEnabled(false);
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(true);
                break;
                
            default: System.out.println("Modo Inválido!");
        }
        
    }
  
    public void ManipulaInterfaceFunc(){
        switch(modoFunc){
            case "Navegar":
                txt_func_matricula.setEnabled(false);
                txt_func_nome.setEnabled(false);
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(false);
                break;
                
            case "Novo":
                txt_func_matricula.setEnabled(true);
                txt_func_nome.setEnabled(true);
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(true);
                break;
                
            case "Editar":
                txt_func_matricula.setEnabled(true);
                txt_func_nome.setEnabled(true);
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(true);
                break;
                
            case "Excluir":
                txt_func_matricula.setEnabled(false);
                txt_func_nome.setEnabled(false);
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(false);
                break;
                
            case "Selecao":
                txt_func_matricula.setEnabled(false);
                txt_func_nome.setEnabled(false);
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                cb_func_deps.setEnabled(false);
                break;
                
            default: System.out.println("Modo Inválido!");
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dep_dpts = new javax.swing.JTable();
        c_dep_codigo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_dep_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_dep_nome = new javax.swing.JTextField();
        btn_dep_salvar = new javax.swing.JButton();
        btn_dep_cancelar = new javax.swing.JButton();
        btn_dep_novo = new javax.swing.JButton();
        btn_dep_editar = new javax.swing.JButton();
        btn_dep_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_func_funcs = new javax.swing.JTable();
        c_dep_codigo1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_func_matricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_func_nome = new javax.swing.JTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_func_deps = new javax.swing.JComboBox<>();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        btn_func_excluir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_dep_dpts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dep_dpts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dep_dptsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dep_dpts);
        if (tbl_dep_dpts.getColumnModel().getColumnCount() > 0) {
            tbl_dep_dpts.getColumnModel().getColumn(0).setResizable(false);
            tbl_dep_dpts.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_dep_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        c_dep_codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel1.setText("Código: ");

        jLabel2.setText("Nome:");

        btn_dep_salvar.setText("Salvar");
        btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_salvarActionPerformed(evt);
            }
        });

        btn_dep_cancelar.setText("Cancelar");
        btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout c_dep_codigoLayout = new javax.swing.GroupLayout(c_dep_codigo);
        c_dep_codigo.setLayout(c_dep_codigoLayout);
        c_dep_codigoLayout.setHorizontalGroup(
            c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_dep_codigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(c_dep_codigoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(c_dep_codigoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(c_dep_codigoLayout.createSequentialGroup()
                                .addComponent(btn_dep_salvar)
                                .addGap(38, 38, 38)
                                .addComponent(btn_dep_cancelar))
                            .addComponent(txt_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        c_dep_codigoLayout.setVerticalGroup(
            c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_dep_codigoLayout.createSequentialGroup()
                .addGroup(c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(c_dep_codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_salvar)
                    .addComponent(btn_dep_cancelar))
                .addContainerGap())
        );

        btn_dep_novo.setText("Novo");
        btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_novoActionPerformed(evt);
            }
        });

        btn_dep_editar.setText("Editar");
        btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_editarActionPerformed(evt);
            }
        });

        btn_dep_excluir.setText("Excluir");
        btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_dep_novo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dep_editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dep_excluir))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(c_dep_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_novo)
                    .addComponent(btn_dep_editar)
                    .addComponent(btn_dep_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Departamentos", jPanel1);

        tbl_func_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_func_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_func_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_func_funcs);
        if (tbl_func_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_func_funcs.getColumnModel().getColumn(0).setResizable(false);
            tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_func_funcs.getColumnModel().getColumn(2).setResizable(false);
        }

        c_dep_codigo1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionário"));

        jLabel3.setText("Matricula:");

        jLabel4.setText("Nome:");

        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Dep:");

        javax.swing.GroupLayout c_dep_codigo1Layout = new javax.swing.GroupLayout(c_dep_codigo1);
        c_dep_codigo1.setLayout(c_dep_codigo1Layout);
        c_dep_codigo1Layout.setHorizontalGroup(
            c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txt_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btn_func_salvar)
                                .addGap(38, 38, 38)
                                .addComponent(btn_func_cancelar))
                            .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_func_deps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        c_dep_codigo1Layout.setVerticalGroup(
            c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_dep_codigo1Layout.createSequentialGroup()
                .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(c_dep_codigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_salvar)
                    .addComponent(btn_func_cancelar))
                .addContainerGap())
        );

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_func_novo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_func_editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_func_excluir))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(c_dep_codigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_editar)
                    .addComponent(btn_func_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_dep_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Funcionários", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
        txt_dep_codigo.setText("");
        txt_dep_nome.setText("");
        modoDep = "Novo";
        ManipulaInterfaceDep();
        
    }//GEN-LAST:event_btn_dep_novoActionPerformed

    private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
       txt_dep_codigo.setText("");
       txt_dep_nome.setText("");
       
       modoDep = "Cancelar";
       ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_cancelarActionPerformed

    private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
        int cod = Integer.parseInt(txt_dep_codigo.getText());
        if(modoDep.equals("Novo")){            
            Departamento D = new Departamento(cod, txt_dep_nome.getText());
            ListaDep.add(D);
        }else if(modoDep.equals("Editar")){
            int index = tbl_dep_dpts.getSelectedRow();
            ListaDep.get(index).setCodigo(cod);
            ListaDep.get(index).setNome(txt_dep_nome.getText());
        }
        
        LoadTableDep();
        modoDep = "Navegar";
        ManipulaInterfaceDep();
        txt_dep_codigo.setText("");
        txt_dep_nome.setText("");
        
    }//GEN-LAST:event_btn_dep_salvarActionPerformed

    private void tbl_dep_dptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dep_dptsMouseClicked
        int index = tbl_dep_dpts.getSelectedRow();
        
        if (index>=0 && index<ListaDep.size()){
            
            Departamento D = ListaDep.get(index);
            txt_dep_codigo.setText(String.valueOf(D.getCodigo()));
            txt_dep_nome.setText(D.getNome());
            modoDep = "Selecao";
            ManipulaInterfaceDep();
        }
        
    }//GEN-LAST:event_tbl_dep_dptsMouseClicked

    private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
        modoDep = "Editar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_editarActionPerformed

    private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
        int index = tbl_dep_dpts.getSelectedRow();
        if (index>=0 && index<ListaDep.size()){  
            ListaDep.remove(index);
       
        }
        LoadTableDep();
        modoDep = "Navegar";
        ManipulaInterfaceDep();
        
    }//GEN-LAST:event_btn_dep_excluirActionPerformed

    private void tbl_func_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_func_funcsMouseClicked
        int index = tbl_func_funcs.getSelectedRow();
        
        if (index>=0 && index<ListaFunc.size()){
            
            Funcionario F = ListaFunc.get(index);
            txt_func_matricula.setText(String.valueOf(F.getMatricula()));
            txt_func_nome.setText(F.getNome());
            modoFunc = "Selecao";
            ManipulaInterfaceFunc();
        }
    }//GEN-LAST:event_tbl_func_funcsMouseClicked

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed

        int index = cb_func_deps.getSelectedIndex();
        if(index == 0){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um departamento");
        }else if(modoFunc.equals("Novo")){
            Funcionario F = new Funcionario();
            F.setMatricula(Integer.parseInt(txt_func_matricula.getText()));
            F.setNome(txt_func_nome.getText());
            F.setDep(ListaDep.get(index-1));
            
            ListaFunc.add(F);
            ListaDep.get(index-1).addFunc(F);
        }else if(modoFunc.equals("Editar")){           
            int id = tbl_func_funcs.getSelectedRow();
            ListaFunc.get(id).setMatricula(Integer.parseInt(txt_func_matricula.getText()));
            ListaFunc.get(id).setNome(txt_func_nome.getText());
            ListaFunc.get(id).setDep(ListaDep.get(index-1));
            
        }
        
        LoadTableFunc();
        modoFunc = "Navegar";
        txt_func_matricula.setText("");
        txt_func_nome.setText("");
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        txt_func_matricula.setText("");
        txt_func_nome.setText("");
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        txt_func_matricula.setText("");
        txt_func_nome.setText("");
        modoFunc = "Novo";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        modoFunc = "Editar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
        int index = tbl_func_funcs.getSelectedRow();
        if (index>=0 && index<ListaFunc.size()){  
            ListaFunc.remove(index);
       
        }
        LoadTableFunc();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dep_cancelar;
    private javax.swing.JButton btn_dep_editar;
    private javax.swing.JButton btn_dep_excluir;
    private javax.swing.JButton btn_dep_novo;
    private javax.swing.JButton btn_dep_salvar;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JPanel c_dep_codigo;
    private javax.swing.JPanel c_dep_codigo1;
    private javax.swing.JComboBox<String> cb_func_deps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_dep_dpts;
    private javax.swing.JTable tbl_func_funcs;
    private javax.swing.JTextField txt_dep_codigo;
    private javax.swing.JTextField txt_dep_nome;
    private javax.swing.JTextField txt_func_matricula;
    private javax.swing.JTextField txt_func_nome;
    // End of variables declaration//GEN-END:variables
}
