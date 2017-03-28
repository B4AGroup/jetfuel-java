package com.eixox.usecase;

import com.eixox.globalization.Culture;
import com.eixox.globalization.Cultures;
import com.eixox.ui.ControlState;
import com.eixox.ui.ControlType;
import com.eixox.ui.UIPresentation;
import com.eixox.ui.UIPresentationMember;

public abstract class Usecase {

	public final UsecaseAspect aspect;
	public final UIPresentation presentation;
	public Culture culture;

	public Usecase(Culture culture) {
		this.culture = culture;
		this.aspect = UsecaseAspect.getInstance(getClass());
		this.presentation = new UIPresentation(this.aspect.getCount());
		for (UsecaseAspectMember member : this.aspect) {
			if (member.ui.controlType != ControlType.NONE)
				this.presentation.add(new UIPresentationMember(member.ui));
		}
	}

	public Usecase() {
		this(Cultures.EN_US);
	}

	public void parsePresentation() {
		for (UIPresentationMember uiMember : this.presentation) {
			UsecaseAspectMember member = this.aspect.get(uiMember.name);
			if (member != null)
				member.parse(this, culture, uiMember.value);
		}
	}
	
	public final void parsePresentation(Culture culture){
		this.culture = culture;
		parsePresentation();
	}

	public void formatPresentation() {
		for (UIPresentationMember uiMember : this.presentation) {
			UsecaseAspectMember member = this.aspect.get(uiMember.name);
			if (member != null)
				uiMember.value = member.getValueToString(this, culture);
		}
	}

	public String getTitle() {
		return toString();
	}
	
	protected void postExecute(UsecaseResult result) {
		
	}
	
	protected void preExecute() {
	}

	public synchronized boolean validate() {
		int l = this.presentation.size();
		boolean valid = true;
		for (int i = 0; i < l; i++) {
			UsecaseAspectMember uam = this.aspect.get(i);
			Object value = uam.getValue(this);
			UIPresentationMember uipm = this.presentation.get(i);
			uipm.message = uam.restrictions.getRestrictionMessageFor(value);
			if (uipm.message != null && uipm.message.length() > 0) {
				uipm.controlState = ControlState.ERROR;
				valid = false;
			} else
				uipm.controlState = ControlState.SUCCESS;
		}
		return valid;
	}

	protected abstract void executeFlow(UsecaseResult result) throws Exception;

	public synchronized final UsecaseResult execute() {
		UsecaseResult result = new UsecaseResult();
		result.presentation = this.presentation;
		
		try {
			preExecute();
			if (validate()) {
				executeFlow(result);
			} else {
				result.message = "Os campos estão inválidos";
				result.resultType = UsecaseResultType.VALIDATION_FAILED;
			}
		} catch (Exception ex) {
			result.exception = ex;
			result.resultType = UsecaseResultType.EXCEPTION;
			result.message = ex.toString();
		}
		try {
			postExecute(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static final boolean isValidName(String name) {
		if (name == null || name.isEmpty())
			return false;

		int l = name.length();

		if (l > 255)
			return false;

		for (int i = 0; i < l; i++) {
			char c = name.charAt(i);
			if (!Character.isLetterOrDigit(c))
				if (c != '-')
					return false;

		}

		return true;
	}

}