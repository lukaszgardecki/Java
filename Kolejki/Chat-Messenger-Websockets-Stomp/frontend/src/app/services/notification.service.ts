import { Injectable } from '@angular/core';
import Swal, { SweetAlertIcon } from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  async displayToast(type: SweetAlertIcon, content: string, timer?: number) {
    await this.toast(type, content, timer);
  }

  async displayErrorToast() {
    await this.toast("error", 'Nie można połączyć się z WebSocket! Odśwież stronę i spróbuj ponownie lub skontaktuj się z administratorem.');
  }

  private async toast(type: SweetAlertIcon, message: string, timer = 5000) {
    await Swal.mixin({
      toast: true,
      position: 'top-end',
      timer: timer,
      showCloseButton: true,
      timerProgressBar: true,
      showConfirmButton: false,
      didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer);
        toast.addEventListener('mouseleave', Swal.resumeTimer);
      }
    }).fire({
      timer: timer,
      icon: type,
      html: message,
    });
  }
}
