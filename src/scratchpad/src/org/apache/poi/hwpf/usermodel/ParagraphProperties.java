/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.types.PAPAbstractType;

public final class ParagraphProperties extends PAPAbstractType implements
        Cloneable {

    private boolean jcLogical = false;
    
    public ParagraphProperties() {
        setAnld(new byte[84]);
        setBrcTop(new BorderCode());
        setBrcLeft(new BorderCode());
        setBrcBottom(new BorderCode());
        setBrcRight(new BorderCode());
        setBrcBetween(new BorderCode());
        setBrcBar(new BorderCode());
        setDcs( new DropCapSpecifier() );
        setLspd( new LineSpacingDescriptor() );
        setShd( new ShadingDescriptor() );
        setPhe( new byte[12] );

        setWidowControl(true);
        getLspd().setMultiLinespace((short) 1);
        getLspd().setDyaLine((short) 240);
        setLvl((byte) 9);
        setRgdxaTab(new int[0]);
        setRgtbd(new byte[0]);
        setDttmPropRMark(new DateAndTime());
    }

    public int getJustification() {
        if (jcLogical) {
            if (getFBiDi() == 0) {
                return getJc();
            }

            switch (getJc()) {
            case 0:
                return 2;
            case 2:
                return 0;
            default:
                return getJc();
            }
        }

        return getJc();
    }

    public void setJustification(byte jc) {
        super.setJc(jc);
        this.jcLogical = false;
    }

    public void setJustificationLogical(byte jc) {
        super.setJc(jc);
        this.jcLogical = true;
    }

    public boolean keepOnPage() {
        return super.getFKeep() != 0;
    }

    public void setKeepOnPage(boolean fKeep) {
        super.setFKeep((byte) (fKeep ? 1 : 0));
    }

    public boolean keepWithNext() {
        return super.getFKeepFollow() != 0;
    }

    public void setKeepWithNext(boolean fKeepFollow) {
        super.setFKeepFollow((byte) (fKeepFollow ? 1 : 0));
    }

    public boolean pageBreakBefore() {
        return super.getFPageBreakBefore() != 0;
    }

    public void setPageBreakBefore(boolean fPageBreak) {
        super.setFPageBreakBefore((byte) (fPageBreak ? 1 : 0));
    }

    public boolean isLineNotNumbered() {
        return super.getFNoLnn() != 0;
    }

    public void setLineNotNumbered(boolean fNoLnn) {
        super.setFNoLnn((byte) (fNoLnn ? 1 : 0));
    }

    public boolean isSideBySide() {
        return super.getFSideBySide() != 0;
    }

    public void setSideBySide(boolean fSideBySide) {
        super.setFSideBySide((byte) (fSideBySide ? 1 : 0));
    }

    public boolean isAutoHyphenated() {
        return super.getFNoAutoHyph() == 0;
    }

    public void setAutoHyphenated(boolean auto) {
        super.setFNoAutoHyph((byte) (!auto ? 1 : 0));
    }

    public boolean isWidowControlled() {
        return super.getFWidowControl() != 0;
    }

    public void setWidowControl(boolean widowControl) {
        super.setFWidowControl((byte) (widowControl ? 1 : 0));
    }

    public int getIndentFromRight() {
        return super.getDxaRight();
    }

    public void setIndentFromRight(int dxaRight) {
        super.setDxaRight(dxaRight);
    }

    public int getIndentFromLeft() {
        return super.getDxaLeft();
    }

    public void setIndentFromLeft(int dxaLeft) {
        super.setDxaLeft(dxaLeft);
    }

    public int getFirstLineIndent() {
        return super.getDxaLeft1();
    }

    public void setFirstLineIndent(int first) {
        super.setDxaLeft1(first);
    }

    public LineSpacingDescriptor getLineSpacing() {
        return super.getLspd();
    }

    public void setLineSpacing(LineSpacingDescriptor lspd) {
        super.setLspd(lspd);
    }

    public int getSpacingBefore() {
        return super.getDyaBefore();
    }

    public void setSpacingBefore(int before) {
        super.setDyaBefore(before);
    }

    public int getSpacingAfter() {
        return super.getDyaAfter();
    }

    public void setSpacingAfter(int after) {
        super.setDyaAfter(after);
    }

    public boolean isKinsoku() {
        return super.getFKinsoku() != 0;
    }

    public void setKinsoku(boolean kinsoku) {
        super.setFKinsoku((byte) (kinsoku ? 1 : 0));
    }

    public boolean isWordWrapped() {
        return super.getFWordWrap() != 0;
    }

    public void setWordWrapped(boolean wrap) {
        super.setFWordWrap((byte) (wrap ? 1 : 0));
    }

    public int getFontAlignment() {
        return super.getWAlignFont();
    }

    public void setFontAlignment(int align) {
        super.setWAlignFont(align);
    }

    public boolean isVertical() {
        return super.isFVertical();
    }

    public void setVertical(boolean vertical) {
        super.setFVertical(vertical);
    }

    public boolean isBackward() {
        return super.isFBackward();
    }

    public void setBackward(boolean bward) {
        super.setFBackward(bward);
    }

    public BorderCode getTopBorder() {
        return super.getBrcTop();
    }

    public void setTopBorder(BorderCode top) {
        super.setBrcTop(top);
    }

    public BorderCode getLeftBorder() {
        return super.getBrcLeft();
    }

    public void setLeftBorder(BorderCode left) {
        super.setBrcLeft(left);
    }

    public BorderCode getBottomBorder() {
        return super.getBrcBottom();
    }

    public void setBottomBorder(BorderCode bottom) {
        super.setBrcBottom(bottom);
    }

    public BorderCode getRightBorder() {
        return super.getBrcRight();
    }

    public void setRightBorder(BorderCode right) {
        super.setBrcRight(right);
    }

    public BorderCode getBarBorder() {
        return super.getBrcBar();
    }

    public void setBarBorder(BorderCode bar) {
        super.setBrcBar(bar);
    }

    public ShadingDescriptor getShading() {
        return super.getShd();
    }

    public void setShading(ShadingDescriptor shd) {
        super.setShd(shd);
    }

    public DropCapSpecifier getDropCap() {
        return super.getDcs();
    }

    public void setDropCap(DropCapSpecifier dcs) {
        super.setDcs(dcs);
    }

    public Object clone() throws CloneNotSupportedException {
        ParagraphProperties pp = (ParagraphProperties) super.clone();
        pp.setAnld(getAnld().clone());
        pp.setBrcTop((BorderCode) getBrcTop().clone());
        pp.setBrcLeft((BorderCode) getBrcLeft().clone());
        pp.setBrcBottom((BorderCode) getBrcBottom().clone());
        pp.setBrcRight((BorderCode) getBrcRight().clone());
        pp.setBrcBetween((BorderCode) getBrcBetween().clone());
        pp.setBrcBar((BorderCode) getBrcBar().clone());
        pp.setDcs( getDcs().clone() );
        pp.setLspd( (LineSpacingDescriptor) getLspd().clone() );
        pp.setShd( (ShadingDescriptor) getShd().clone() );
        pp.setPhe( getPhe().clone() );
        return pp;
    }

}
