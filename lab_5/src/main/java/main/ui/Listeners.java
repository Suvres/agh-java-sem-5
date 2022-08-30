package main.ui;

import main.JStudent.JUniversityTable;
import main.JStudent.UniversityTableModel;
import main.student.Class;
import main.student.Student;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;

public class Listeners {

    public static void groupsListener() {
        if(Gui.modelGroups == null) {
            return;
        }

        Gui.groupsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JUniversityTable target = (JUniversityTable)e.getSource();
                int row = target.getSelectedRow();

                Gui._group = Gui._container.getClass(target.getValueAt(row, 0).toString());
                fillStudents();
            }
        });
    }

    public static void studentsListener() {
        if(Gui.modelStudents == null) {
            return;
        }

        Gui.studentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JUniversityTable target = (JUniversityTable)e.getSource();
                int row = target.getSelectedRow();

                Gui._student = Gui._group.getStudent(Integer.parseInt(target.getValueAt(row, 2).toString()));
            }
        });
    }

    public static void groupsButtonsListListeners() {
        Gui.groupsEditButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._group == null) {
                    return;
                }

                Gui.editGroup();
            }
        });

        Gui.groupsDelButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._group == null) {
                    return;
                }

                Gui.delGroup();
            }
        });

        Gui.groupsAddButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Gui.addGroup();
            }
        });
    }

    public static void studentsButtonsListListeners() {
        Gui.studentsAddButtons.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._group == null) {
                    return;
                }

                Optional<Student> max = Gui._group.getStudentsList().stream().max((o1, o2) -> {
                    if(o1.getIndex() == o2.getIndex()) {
                        return 0;
                    }

                    return o1.getIndex() < o2.getIndex() ? -1 : 1;
                });

                Gui.studentAdd(max.map(student -> student.getIndex() + 1).orElse(1));
            }
        });

        Gui.studentsDelButtons.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._student == null) {
                    return;
                }

                Gui._group.removeStudent(Gui._student);
                Gui._student = null;
                fillStudents();
                fillGroups();
            }
        });

        Gui.studentsViewButtons.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._student == null) {
                    return;
                }

                Gui.studentView();
            }
        });

        Gui.studentsEditButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Gui.editStudent();
            }
        });

        Gui.studentsSortButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Gui._group == null) {
                    return;
                }
                Gui.sortStudent();
            }
        });

        Gui.filterText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(Gui.filterText.getText().length() > 2) {
                    try {
                        Gui.sorter.setRowFilter(RowFilter.regexFilter(Gui.filterText.getText()));
                    } catch(PatternSyntaxException pse) {
                        System.out.println("Bad regex pattern");
                    }
                } else {
                    Gui.sorter.setRowFilter(null);
                }
            }
        });
    }

    static void fillStudents() {

        Gui.modelStudents = new UniversityTableModel(new String[]{"Imie", "Nazwisko", "Indeks", "Stan"});

        if(Gui._group != null) {
            Student[] _students = Gui._group.getStudentsList().toArray(new Student[0]);

            for(int i = 0; i < _students.length; i++) {
                Gui.modelStudents.addData(i, _students[i].__toArray());
            }

        }

        Gui.studentsTable.setModel(Gui.modelStudents);
        Gui.sorter = new TableRowSorter<>(Gui.modelStudents);
        Gui.studentsTable.setRowSorter(Gui.sorter);
        Gui.studentsTable.doLayout();
    }

    public static void fillGroups() {
        Gui.modelGroups = new UniversityTableModel(new String[]{"Nazwa", "Ilośc studentów", "Maksymalna ilośc studentów"});
        Class[] classes = Gui._container.getGroups().values().toArray(new Class[0]);

        for(int i = 0; i < Gui._container.getGroups().size(); i++) {
            Gui.modelGroups.addData(i, classes[i].__toArray());
        }

        Gui.groupsTable.setModel(Gui.modelGroups);
        Gui.groupsTable.doLayout();
    }
}
