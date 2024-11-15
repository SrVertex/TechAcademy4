class FormValidator {
    private form: HTMLFormElement;
    private campos: NodeListOf<HTMLInputElement>;
    private spans: NodeListOf<HTMLSpanElement>;
    private emailRegex: RegExp;

    constructor() {
        this.form = document.getElementById('form') as HTMLFormElement;
        this.campos = document.querySelectorAll('.required') as NodeListOf<HTMLInputElement>;
        this.spans = document.querySelectorAll('.span-required') as NodeListOf<HTMLSpanElement>;
        this.emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

        this.form.addEventListener('submit', this.handleSubmit.bind(this));
    }

    private setError(index: number): void {
        this.campos[index].style.border = '2px solid #e63636';
        this.spans[index].style.display = 'block';
    }

    private removeError(index: number): void {
        this.campos[index].style.border = '2px solid #fff';
        this.spans[index].style.display = 'none';
    }

    private emailValidate(): void {
        if (!this.emailRegex.test(this.campos[0].value)) {
            this.setError(0);
        } else {
            this.removeError(0);
        }
    }

    private nomeValidate(): void {
        if (this.campos[1].value.length < 3) {
            this.setError(1);
        } else {
            this.removeError(1);
        }
    }

    private mainPasswordValidate(): void {
        if (this.campos[2].value.length < 8) {
            this.setError(2);
        } else {
            this.removeError(2);
        }
    }

    private mainPasswordValidate2(): void {
        if (this.campos[3].value.length < 8) {
            this.setError(3);
        } else {
            this.removeError(3);
        }
    }

    private handleSubmit(event: Event): void {
        this.emailValidate();
        this.nomeValidate();
        this.mainPasswordValidate();
        this.mainPasswordValidate2();
        if (!this.emailRegex.test(this.campos[0].value) ||
            this.campos[1].value.length < 3 ||
            this.campos[2].value.length < 8 ||
            this.campos[3].value.length < 8) {
            event.preventDefault();
        }
    }
}

const validator = new FormValidator();
