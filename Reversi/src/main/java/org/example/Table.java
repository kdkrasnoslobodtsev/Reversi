package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Table {
    private ArrayList<ArrayList<String>> field;

    public ArrayList<ArrayList<Double>> moves;

    public Table(Integer rows) {
        field = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < rows; ++i) {
            field.add(new ArrayList<String>());
            for (int j = 0; j < 8; ++j) {
                field.get(i).add("*");
            }
        }
    }

    public ArrayList<ArrayList<Double>> findMoves(String ch) {
        ArrayList<ArrayList<Double>> res = new ArrayList<ArrayList<Double>>();
        String check;
        if (ch == "b") {
            check = "w";
        } else {
            check = "b";
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (field.get(i).get(j) != ch && field.get(i).get(j) != check) {
                    if (i == 0 && j == 0) {
                        int count = 0, iter = 1, jter = 0;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - 1;
                        }
                        iter = 0;
                        jter = 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - 1;
                        }
                        iter = 1;
                        jter = 1;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(count + 0.8);
                        }
                    } else if (i == 7 && j == 0) {
                        int count = 0, iter = 6, jter = 0;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += 6 - iter;
                        }
                        iter = 7;
                        jter = 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - 1;
                        }
                        iter = 6;
                        jter = 1;
                        while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(count + 0.8);
                        }
                    } else if (i == 0 && j == 7) {
                        int count = 0, iter = 1, jter = 7;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - 1;
                        }
                        iter = 0;
                        jter = 6;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += 6 - jter;
                        }
                        iter = 1;
                        jter = j;
                        while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(count + 0.8);
                        }
                    } else if (i == 7 && j == 7) {
                        int count = 0, iter = 6, jter = 7;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += 6 - iter;
                        }
                        iter = 7;
                        jter = 6;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += 6 - jter;
                        }
                        iter = 6;
                        jter = 6;
                        while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += 6 - iter;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(count + 0.8);
                        }
                    }
                    else if (i == 0) {
                        int count = 0, iter = 1, jter = j;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = 0;
                        jter = j + 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = 1;
                        jter = j + 1;
                        while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = 1;
                        jter = j - 1;
                        while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = 0;
                        jter = j - 1;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += j - jter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(j + 0.0);
                            res.get(res.size() - 1).add(count + 0.4);
                        }
                    }
                    else if (j == 0) {
                        int count = 0, iter = i + 1, jter = 0;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i;
                        jter = 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = i - 1;
                        jter = 0;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        iter = i + 1;
                        jter = j + 1;
                        while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i - 1;
                        jter = j + 1;
                        while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(i + 0.0);
                            res.get(res.size() - 1).add(0.0);
                            res.get(res.size() - 1).add(count + 0.4);
                        }
                    }
                    else if (i == 7) {
                        int count = 0, iter = 7, jter = j + 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = 7;
                        jter = j - 1;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += j - jter - 1;
                        }
                        iter = 6;
                        jter = j;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        iter = 6;
                        jter = j + 1;
                        while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = 6;
                        jter = j - 1;
                        while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(j + 0.0);
                            res.get(res.size() - 1).add(count + 0.4);
                        }
                    } else if (j == 7) {
                        int count = 0, iter = i + 1, jter = 7;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i - 1;
                        jter = 7;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        iter = i;
                        jter = 6;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += j - jter - 1;
                        }
                        iter = i - 1;
                        jter = 6;
                        while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        iter = i + 1;
                        jter = 6;
                        while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(i + 0.0);
                            res.get(res.size() - 1).add(7.0);
                            res.get(res.size() - 1).add(count + 0.4);
                        }
                    } else {
                        int count = 0, iter = i - 1, jter = j - 1;
                        while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += j - jter - 1;
                        }
                        iter = i - 1;
                        jter = j;
                        while (iter != 0 && field.get(iter).get(jter) == check) {
                            iter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += i - iter - 1;
                        }
                        iter = i - 1;
                        jter = j + 1;
                        while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter--;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = i;
                        jter = j + 1;
                        while (jter != 7 && field.get(iter).get(jter) == check) {
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += jter - j - 1;
                        }
                        iter = i + 1;
                        jter = j + 1;
                        while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i + 1;
                        jter = j;
                        while (iter != 7 && field.get(iter).get(jter) == check) {
                            iter++;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i + 1;
                        jter = j - 1;
                        while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                            iter++;
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += iter - i - 1;
                        }
                        iter = i;
                        jter = j - 1;
                        while (jter != 0 && field.get(iter).get(jter) == check) {
                            jter--;
                        }
                        if (field.get(iter).get(jter) == ch) {
                            count += j - jter - 1;
                        }
                        if (count != 0) {
                            res.add(new ArrayList<Double>());
                            res.get(res.size() - 1).add(i + 0.0);
                            res.get(res.size() - 1).add(j + 0.0);
                            res.get(res.size() - 1).add(count + 0.0);
                        }
                    }
                }
            }
        }
        return res;
    }

    public void printTable(Player pl) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (field.get(i).get(j) != "*" && field.get(i).get(j) != "b" && field.get(i).get(j) != "w") {
                    field.get(i).set(j, "*");
                }
            }
        }
        moves = findMoves(pl.chip);
        for(int i = 0; i < moves.size(); ++i) {
            field.get(moves.get(i).get(0).intValue()).set(moves.get(i).get(1).intValue(), moves.get(i).get(2).toString());
        }
        for (int i = 1; i <= 8; ++i) {
            System.out.print("\t\t" + i);
        }
        System.out.println();
        for (int i = 0; i < field.size(); ++i) {
            System.out.print((i + 1) + "\t\t");
            for (int j = 0; j < field.get(i).size(); ++j) {
                System.out.print(field.get(i).get(j) + "\t\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    private void eat(Integer i, Integer j, String ch) {
        String check;
        if (ch == "w") {
            check = "b";
        } else {
            check = "w";
        }
        if (i == 0 && j == 0) {
            int count = 0, iter = 1, jter = 0;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = 0;
            jter = 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = 1;
            jter = 1;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                jter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter++;
                }
            }
        } else if (i == 7 && j == 0) {
            int count = 0, iter = 6, jter = 0;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = 7;
            jter = 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = 6;
            jter = 1;
            while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                iter--;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                jter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter++;
                }
            }
        } else if (i == 0 && j == 7) {
            int count = 0, iter = 1, jter = 7;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = 0;
            jter = 6;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter--;
                }
            }
            iter = 1;
            jter = 6;
            while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                iter++;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter--;
                }
            }
        } else if (i == 7 && j == 7) {
            int count = 0, iter = 6, jter = 7;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = 7;
            jter = 6;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = 6;
            jter = 6;
            while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                iter--;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter--;
                }
            }
        }
        else if (i == 0) {
            int count = 0, iter = 1, jter = j;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = 0;
            jter = j + 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = 1;
            jter = j + 1;
            while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                iter++;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter++;
                }
            }
            iter = 1;
            jter = j - 1;
            while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                iter++;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 1;
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter--;
                }
            }
            iter = 0;
            jter = j - 1;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter--;
                }
            }
        }
        else if (j == 0) {
            int count = 0, iter = i + 1, jter = 0;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = i;
            jter = 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = i - 1;
            jter = 0;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = i + 1;
            jter = j + 1;
            while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                iter++;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter++;
                }
            }
            iter = i - 1;
            jter = j + 1;
            while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                iter--;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter++;
                }
            }
        }
        else if (i == 7) {
            int count = 0, iter = 7, jter = j + 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 7;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = 7;
            jter = j - 1;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter--;
                }
            }
            iter = 6;
            jter = j;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = 6;
            jter = j + 1;
            while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                iter--;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter++;
                }
            }
            iter = 6;
            jter = j - 1;
            while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                iter--;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = 6;
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter--;
                }
            }
        } else if (j == 7) {
            int count = 0, iter = i + 1, jter = 7;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = i - 1;
            jter = 7;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = i;
            jter = 6;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter--;
                }
            }
            iter = i - 1;
            jter = 6;
            while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                iter--;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter--;
                }
            }
            iter = i + 1;
            jter = 6;
            while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                iter++;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                jter = 6;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter--;
                }
            }
        } else {
            int count = 0, iter = i - 1, jter = j - 1;
            while (iter != 0 && jter != 0 && field.get(iter).get(jter) == check) {
                iter--;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter--;
                }
            }
            iter = i - 1;
            jter = j;
            while (iter != 0 && field.get(iter).get(jter) == check) {
                iter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                }
            }
            iter = i - 1;
            jter = j + 1;
            while (iter != 0 && jter != 7 && field.get(iter).get(jter) == check) {
                iter--;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i - 1;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter--;
                    jter++;
                }
            }
            iter = i;
            jter = j + 1;
            while (jter != 7 && field.get(iter).get(jter) == check) {
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter++;
                }
            }
            iter = i + 1;
            jter = j + 1;
            while (iter != 7 && jter != 7 && field.get(iter).get(jter) == check) {
                iter++;
                jter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                jter = j + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter++;
                }
            }
            iter = i + 1;
            jter = j;
            while (iter != 7 && field.get(iter).get(jter) == check) {
                iter++;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                }
            }
            iter = i + 1;
            jter = j - 1;
            while (iter != 7 && jter != 0 && field.get(iter).get(jter) == check) {
                iter++;
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                iter = i + 1;
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    iter++;
                    jter--;
                }
            }
            iter = i;
            jter = j - 1;
            while (jter != 0 && field.get(iter).get(jter) == check) {
                jter--;
            }
            if (field.get(iter).get(jter) == ch) {
                jter = j - 1;
                while (field.get(iter).get(jter) == check) {
                    field.get(iter).set(jter, ch);
                    jter--;
                }
            }

        }
    }

    public String get(Integer x, Integer y) {
        return field.get(x).get(y);
    }

    public void set(Integer x, Integer y, String ch) {
        field.get(x).set(y, ch);
        eat(x, y, ch);
    }

    public int findPoints(String chip) {
        Integer count = 0;
        for (int i = 0; i < field.size(); ++i) {
            for (int j = 0; j < field.get(i).size(); ++j) {
                if (field.get(i).get(j) == chip) {
                    count++;
                }
            }
        }
        return count;
    }
}