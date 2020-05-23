import { AppInfoService } from './../../servicios/app-info.service';
import {
  faFacebookSquare,
  faGithubSquare,
  faGitlab,
} from '@fortawesome/free-brands-svg-icons';
import { Component, OnInit } from '@angular/core';
import { faEnvelope as farEnvelope } from '@fortawesome/free-regular-svg-icons';

@Component({
  selector: 'app-pie',
  templateUrl: './pie.component.html',
  styleUrls: ['./pie.component.css'],
})
export class PieComponent implements OnInit {
  version: string;
  nombreAutor: string;

  faFacebookSquare = faFacebookSquare;
  faGithubSquare = faGithubSquare;
  faGitlab = faGitlab;
  farEnvelope = farEnvelope;

  constructor(private appInfoService: AppInfoService) {}

  ngOnInit(): void {
    this.version = this.appInfoService.getVersionApp();
    this.nombreAutor = this.appInfoService.getNombreAutor();
  }
}
