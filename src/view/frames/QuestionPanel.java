package view.frames;

import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {

    private JLabel questionName;

    private JLabel firstVariant;
    private JLabel secondVariant;
    private JLabel thirdVariant;
    private JLabel fourthVariant;

    private JRadioButton firstRBtn;
    private JRadioButton secondRBtn;
    private JRadioButton thirdRBtn;
    private JRadioButton fourthRBtn;

    QuestionPanel(QuestionPOJO questionPOJO) {
        initComponents();

        this.questionName.setText(questionPOJO.getQuestionName());
        this.questionName.setHorizontalAlignment(SwingConstants.CENTER);

        this.firstVariant.setText(questionPOJO.getFirstVariant());
        this.secondVariant.setText(questionPOJO.getSecondVariant());
        this.thirdVariant.setText(questionPOJO.getThirdVariant());
        this.fourthVariant.setText(questionPOJO.getFourthVariant());

        setLayout(new GridLayout(2, 1));
        add(questionName, BorderLayout.NORTH);

        /**панель для вариатнтов ответов*/
        JPanel variant = new JPanel();
        variant.setLayout(new GridLayout(4, 2));
        variant.add(firstVariant);
        variant.add(firstRBtn);
        variant.add(secondVariant);
        variant.add(secondRBtn);
        variant.add(thirdVariant);
        variant.add(thirdRBtn);
        variant.add(fourthVariant);
        variant.add(fourthRBtn);

        add(variant, BorderLayout.NORTH);

    }

    private void initComponents() {
        questionName = new JLabel();

        firstVariant = new JLabel();
        secondVariant = new JLabel();
        thirdVariant = new JLabel();
        fourthVariant = new JLabel();

        firstRBtn = new JRadioButton();
        secondRBtn = new JRadioButton();
        thirdRBtn = new JRadioButton();
        fourthRBtn = new JRadioButton();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(firstRBtn);
        buttonGroup.add(secondRBtn);
        buttonGroup.add(thirdRBtn);
        buttonGroup.add(fourthRBtn);

    }

    public JLabel getQuestionName() {
        return questionName;
    }

    public void setQuestionName(JLabel questionName) {
        this.questionName = questionName;
    }

    public JLabel getFirstVariant() {
        return firstVariant;
    }

    public void setFirstVariant(JLabel firstVariant) {
        this.firstVariant = firstVariant;
    }

    public JLabel getSecondVariant() {
        return secondVariant;
    }

    public void setSecondVariant(JLabel secondVariant) {
        this.secondVariant = secondVariant;
    }

    public JLabel getThirdVariant() {
        return thirdVariant;
    }

    public void setThirdVariant(JLabel thirdVariant) {
        this.thirdVariant = thirdVariant;
    }

    public JLabel getFourthVariant() {
        return fourthVariant;
    }

    public void setFourthVariant(JLabel fourthVariant) {
        this.fourthVariant = fourthVariant;
    }

    public JRadioButton getFirstRBtn() {
        return firstRBtn;
    }

    public void setFirstRBtn(JRadioButton firstRBtn) {
        this.firstRBtn = firstRBtn;
    }

    public JRadioButton getSecondRBtn() {
        return secondRBtn;
    }

    public void setSecondRBtn(JRadioButton secondRBtn) {
        this.secondRBtn = secondRBtn;
    }

    public JRadioButton getThirdRBtn() {
        return thirdRBtn;
    }

    public void setThirdRBtn(JRadioButton thirdRBtn) {
        this.thirdRBtn = thirdRBtn;
    }

    public JRadioButton getFourthRBtn() {
        return fourthRBtn;
    }

    public void setFourthRBtn(JRadioButton fourthRBtn) {
        this.fourthRBtn = fourthRBtn;
    }
}
